import org.objectweb.asm.*;
import org.objectweb.asm.commons.*;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.tree.analysis.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

/**
 * mc-web TeaVM bytecode patcher (MIT License).
 *
 *   java Patch rules.txt out.jar in1.jar in2.jar ...
 *
 * Applied to every class of every input jar, written into one output jar:
 *  1. class remaps        "class a/b/C -> x/y/Z"
 *  2. call redirects      "call owner.name(desc) -> shim/Owner.newName"   (any invoke -> invokestatic, receiver first)
 *  3. ctor arg dropping   "ctor owner(desc) -> keep 1,2"                  (drops the other arguments)
 *  4. VarHandle lowering  findVarHandle/arrayElementVarHandle fields become direct field/array access helpers.
 *     TeaVM threads are green threads that only switch at blocking calls, so plain reads/writes are atomic.
 *  5. class drops         "drop a/b/C"                                    (class omitted from the output)
 */
public class Patch {
    static final Map<String, String> classMap = new HashMap<>();
    static final Map<String, String[]> calls = new HashMap<>();      // owner.name+desc -> {shimOwner, shimName}
    static final Map<String, int[]> ctors = new HashMap<>();         // owner+desc -> kept arg indices
    static final Set<String> drops = new HashSet<>();
    static final Map<String, String> refMap = new HashMap<>();   // "refclass": rename references only, keep the class itself
    static final Map<String, String> bodies = new HashMap<>();
    static final List<String> jsnativePrefixes = new ArrayList<>();
    static final List<String> stubNativePrefixes = new ArrayList<>();
    static final ClassNode jsn = new ClassNode();
    static final List<String> nativeRows = new ArrayList<>();
    static final List<String> sigRows = new ArrayList<>();
    static int unsupportedNatives = 0;   // owner.name(desc) or owner.name -> "default" | shimOwner.method
    // VarHandle static field "Owner.FIELD" -> {kind, fieldOwner, fieldName, fieldDesc}; kind = "i"(instance) "s"(static) "a"(array element)
    static final Map<String, String[]> vhFields = new HashMap<>();
    // Unsafe offset static field "Owner.FIELD" -> {fieldOwner, fieldName}
    static final Map<String, String[]> offFields = new HashMap<>();
    static Map<String, ClassNode> byName = new HashMap<>();
    static int unsafeCalls = 0;
    static final ClassNode helper = new ClassNode();
    static final Set<String> helperMethods = new HashSet<>();
    static int vhCalls = 0, redirected = 0, frounded = 0;
    static final List<String> froundPrefixes = new ArrayList<>();

    /** JS has no 32-bit float math: round float results like the JVM does (TeaVM keeps them as doubles). */
    static void fround(MethodNode m) {
        for (AbstractInsnNode i : m.instructions.toArray()) {
            int op = i.getOpcode();
            boolean f = op == Opcodes.FADD || op == Opcodes.FSUB || op == Opcodes.FMUL || op == Opcodes.FDIV || op == Opcodes.FREM
                || op == Opcodes.I2F || op == Opcodes.L2F || op == Opcodes.D2F
                || (op == Opcodes.LDC && ((LdcInsnNode) i).cst instanceof Float);
            if (!f) continue;
            m.instructions.insert(i, new MethodInsnNode(Opcodes.INVOKESTATIC, "mcweb/rt/F32", "r", "(F)F", false));
            frounded++;
        }
    }

    public static void main(String[] a) throws Exception {
        for (String line : Files.readAllLines(Paths.get(a[0]))) {
            line = line.replaceAll("#.*", "").trim();
            if (line.isEmpty()) continue;
            String[] p = line.split("\\s+");
            switch (p[0]) {
                case "class": classMap.put(p[1], p[3]); break;
                case "drop": drops.add(p[1]); break;
                case "refclass": refMap.put(p[1], p[3]); break;
                case "body": bodies.put(p[1], p[3]); break;
                case "jsnatives": jsnativePrefixes.add(p[1]); break;
                case "stubnatives": stubNativePrefixes.add(p[1]); break;
                case "fround": froundPrefixes.add(p[1]); break;
                case "call": {
                    int d = p[3].lastIndexOf('.');
                    calls.put(p[1], new String[]{p[3].substring(0, d), p[3].substring(d + 1)});
                    break;
                }
                case "ctor": {
                    String ksrc = p.length > 4 ? p[4] : ""; String[] ks = ksrc.isEmpty() ? new String[0] : ksrc.split(",");
                    int[] k = new int[ks.length];
                    for (int i = 0; i < k.length; i++) k[i] = Integer.parseInt(ks[i]);
                    ctors.put(p[1], k);
                    break;
                }
                default: throw new IllegalArgumentException(line);
            }
        }
        jsn.version = Opcodes.V1_8; jsn.access = Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL;
        jsn.name = "mcweb/jsn/N"; jsn.superName = "java/lang/Object";
        helper.version = Opcodes.V1_8; helper.access = Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL;
        helper.name = "mcweb/vh/VH"; helper.superName = "java/lang/Object";
        Map<String, byte[]> all = new LinkedHashMap<>();
        Map<String, byte[]> res = new LinkedHashMap<>();
        for (int i = 2; i < a.length; i++) {
            try (ZipInputStream z = new ZipInputStream(new FileInputStream(a[i]))) {
                ZipEntry e;
                while ((e = z.getNextEntry()) != null) {
                    if (e.isDirectory()) continue;
                    byte[] d = z.readAllBytes();
                    String n = e.getName();
                    if (n.endsWith(".class") && !n.startsWith("META-INF/")) { if (!all.containsKey(n)) all.put(n, d); }
                    else if (!res.containsKey(n) && !n.endsWith(".SF") && !n.endsWith(".RSA") && !n.endsWith(".DSA")) res.put(n, d);
                }
            }
        }
        // pass 1: find VarHandle fields
        Map<String, ClassNode> nodes = new LinkedHashMap<>();
        for (Map.Entry<String, byte[]> e : all.entrySet()) {
            ClassNode cn = new ClassNode();
            new ClassReader(e.getValue()).accept(cn, 0);
            nodes.put(e.getKey(), cn);
            byName.put(cn.name, cn);
        }
        for (ClassNode cn : nodes.values()) { scanVarHandles(cn); scanUnsafe(cn); }
        System.out.println("unsafe offset fields: " + offFields.size());
        System.out.println("varhandle fields: " + vhFields.size());
        final String[] writing = new String[1];
        Remapper rm = new Remapper() { @Override public String map(String n) {
            if (refMap.containsKey(n) && !n.equals(writing[0])) return refMap.get(n);
            return classMap.getOrDefault(n, n);
        } };
        int n = 0;
        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(a[1]))) {
            for (Map.Entry<String, ClassNode> e : nodes.entrySet()) {
                ClassNode cn = e.getValue();
                if (drops.contains(cn.name) || classMap.containsKey(cn.name)) continue;
                if (cn.signature != null && cn.signature.contains("<")) {
                    String sg = rm.mapSignature(cn.signature, false);
                    sigRows.add("\"" + rm.map(cn.name).replace('/', '.') + "\":\"" + sg.replace("\\", "\\\\").replace("\"", "\\\"") + "\"");
                }
                for (MethodNode m : cn.methods) {
                    String tgt = bodies.get(cn.name + "." + m.name + m.desc);
                    if (tgt == null) tgt = bodies.get(cn.name + "." + m.name);
                    if (tgt != null) { replaceBody(cn, m, tgt); continue; }
                    if ((m.access & Opcodes.ACC_NATIVE) != 0 && isJsNativeClass(cn.name)) { bridgeNative(cn, m); continue; }
                    if ((m.access & Opcodes.ACC_NATIVE) != 0) { for (String sp : stubNativePrefixes) if (cn.name.startsWith(sp)) { replaceBody(cn, m, "default"); break; } }
                    lowerVarHandles(cn, m); lowerUnsafe(cn, m); redirect(m); unsupportedHandles(m);
                    for (String fp : froundPrefixes) if (cn.name.startsWith(fp)) { fround(m); break; }
                }
                ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
                writing[0] = cn.name;
                cn.accept(new ClassRemapper(cw, rm));
                out.putNextEntry(new ZipEntry(rm.map(cn.name) + ".class"));
                writing[0] = null;
                out.write(cw.toByteArray());
                out.closeEntry();
                n++;
            }
            Files.write(Paths.get(a[1] + ".sigs.json"), ("{\n" + String.join(",\n", sigRows) + "\n}\n").getBytes("UTF-8"));
            if (!jsn.methods.isEmpty()) {
                ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
                jsn.accept(new ClassRemapper(cw, rm));
                out.putNextEntry(new ZipEntry(jsn.name + ".class"));
                out.write(cw.toByteArray());
                out.closeEntry();
                Files.write(Paths.get(a[1] + ".natives.json"), ("[\n" + String.join(",\n", nativeRows) + "\n]\n").getBytes("UTF-8"));
            }
            if (!helper.methods.isEmpty()) {
                ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
                helper.accept(new ClassRemapper(cw, rm));
                out.putNextEntry(new ZipEntry(helper.name + ".class"));
                out.write(cw.toByteArray());
                out.closeEntry();
            }
            for (Map.Entry<String, byte[]> e : res.entrySet()) {
                out.putNextEntry(new ZipEntry(e.getKey()));
                out.write(e.getValue());
                out.closeEntry();
            }
        }
        System.out.println("classes=" + n + " vhCalls=" + vhCalls + " unsafeCalls=" + unsafeCalls + " helpers=" + helper.methods.size() + " redirected=" + redirected + " bodies=" + bodiesReplaced + " unsupportedHandles=" + unsupportedCalls + " jsnatives=" + nativeRows.size() + " unsupportedNatives=" + unsupportedNatives + " frounded=" + frounded);
    }

    // ---------------------------------------------------------------- VarHandle discovery
    static void scanVarHandles(ClassNode cn) throws AnalyzerException {
        for (MethodNode m : cn.methods) {
            if (m.instructions.size() == 0) continue;
            boolean any = false;
            for (AbstractInsnNode i : m.instructions) if (i instanceof MethodInsnNode && isVhFactory((MethodInsnNode) i)) any = true;
            if (!any) continue;
            Frame<SourceValue>[] fr = new Analyzer<>(new SourceInterpreter()).analyze(cn.name, m);
            AbstractInsnNode[] ins = m.instructions.toArray();
            for (int k = 0; k < ins.length; k++) {
                if (!(ins[k] instanceof MethodInsnNode) || !isVhFactory((MethodInsnNode) ins[k]) || fr[k] == null) continue;
                MethodInsnNode mi = (MethodInsnNode) ins[k];
                // where does the result go?
                FieldInsnNode put = null;
                for (int j = k + 1; j < ins.length && j < k + 4; j++) {
                    if (ins[j] instanceof FieldInsnNode && ins[j].getOpcode() == Opcodes.PUTSTATIC) { put = (FieldInsnNode) ins[j]; break; }
                    if (ins[j].getOpcode() >= 0 && !(ins[j] instanceof LabelNode) && !(ins[j] instanceof LineNumberNode)) break;
                }
                Frame<SourceValue> f = fr[k];
                int top = f.getStackSize();
                String[] desc;
                if (mi.name.equals("arrayElementVarHandle")) {
                    Type t = constType(f.getStack(top - 1));
                    if (t == null) continue;
                    desc = new String[]{"a", t.getDescriptor(), "", t.getElementType().getDescriptor()};
                } else {
                    Type owner = constType(f.getStack(top - 3));
                    String name = constString(f.getStack(top - 2));
                    Type ft = constType(f.getStack(top - 1));
                    if (owner == null || name == null || ft == null) { System.out.println("WARN unresolved VH in " + cn.name + "." + m.name); continue; }
                    desc = new String[]{mi.name.equals("findStaticVarHandle") ? "s" : "i", owner.getInternalName(), name, ft.getDescriptor()};
                }
                if (put != null) vhFields.put(put.owner + "." + put.name, desc);
            }
        }
    }

    static boolean isUnsafe(String owner) { return owner.equals("jdk/internal/misc/Unsafe") || owner.equals("sun/misc/Unsafe"); }

    static void scanUnsafe(ClassNode cn) throws AnalyzerException {
        for (MethodNode m : cn.methods) {
            boolean any = false;
            for (AbstractInsnNode i : m.instructions)
                if (i instanceof MethodInsnNode && isUnsafe(((MethodInsnNode) i).owner) && ((MethodInsnNode) i).name.equals("objectFieldOffset")) any = true;
            if (!any) continue;
            Frame<SourceValue>[] fr = new Analyzer<>(new SourceInterpreter()).analyze(cn.name, m);
            AbstractInsnNode[] ins = m.instructions.toArray();
            for (int k = 0; k < ins.length; k++) {
                if (!(ins[k] instanceof MethodInsnNode) || fr[k] == null) continue;
                MethodInsnNode mi = (MethodInsnNode) ins[k];
                if (!isUnsafe(mi.owner) || !mi.name.equals("objectFieldOffset") || !mi.desc.startsWith("(Ljava/lang/Class;")) continue;
                int top = fr[k].getStackSize();
                Type owner = constType(fr[k].getStack(top - 2));
                String name = constString(fr[k].getStack(top - 1));
                if (owner == null || name == null) { System.out.println("WARN unresolved Unsafe offset in " + cn.name + "." + m.name); continue; }
                for (int j = k + 1; j < ins.length && j < k + 4; j++) {
                    if (ins[j] instanceof FieldInsnNode && ins[j].getOpcode() == Opcodes.PUTSTATIC) {
                        offFields.put(((FieldInsnNode) ins[j]).owner + "." + ((FieldInsnNode) ins[j]).name, new String[]{owner.getInternalName(), name});
                        break;
                    }
                }
            }
        }
    }

    static String fieldDesc(String owner, String name) {
        for (ClassNode c = byName.get(owner); c != null; c = byName.get(c.superName))
            for (FieldNode f : c.fields) if (f.name.equals(name)) return f.desc;
        return null;
    }

    /** Unsafe op name -> VarHandle-style op name understood by helperFor */
    static String unsafeOp(String n) {
        if (n.startsWith("weakCompareAndSet") || n.startsWith("compareAndSet")) return "compareAndSet";
        if (n.startsWith("compareAndExchange")) return "compareAndExchange";
        if (n.startsWith("getAndAdd")) return "getAndAdd";
        if (n.startsWith("getAndSet")) return "getAndSet";
        if (n.startsWith("getAndBitwiseOr")) return "getAndBitwiseOr";
        if (n.startsWith("getAndBitwiseAnd")) return "getAndBitwiseAnd";
        if (n.matches("get(Int|Long|Reference|Object|Boolean|Byte|Short|Char|Float|Double)(Volatile|Acquire|Opaque)?")) return "get";
        if (n.matches("put(Int|Long|Reference|Object|Boolean|Byte|Short|Char|Float|Double)(Volatile|Release|Opaque)?")) return "set";
        return null;
    }

    static void lowerUnsafe(ClassNode cn, MethodNode m) throws AnalyzerException {
        boolean any = false;
        for (AbstractInsnNode i : m.instructions) if (i instanceof MethodInsnNode && isUnsafe(((MethodInsnNode) i).owner)) any = true;
        if (!any) return;
        Frame<SourceValue>[] fr = new Analyzer<>(new SourceInterpreter()).analyze(cn.name, m);
        AbstractInsnNode[] ins = m.instructions.toArray();
        for (int k = 0; k < ins.length; k++) {
            if (!(ins[k] instanceof MethodInsnNode) || fr[k] == null) continue;
            MethodInsnNode mi = (MethodInsnNode) ins[k];
            if (!isUnsafe(mi.owner)) continue;
            Type[] at = Type.getArgumentTypes(mi.desc);
            if (mi.name.equals("getUnsafe") || mi.name.equals("objectFieldOffset") || mi.name.endsWith("Fence")
                || mi.name.equals("arrayBaseOffset") || mi.name.equals("arrayIndexScale")) {
                InsnList l = new InsnList();
                for (int a2 = at.length - 1; a2 >= 0; a2--) l.add(new InsnNode(at[a2].getSize() == 2 ? Opcodes.POP2 : Opcodes.POP));
                if (mi.getOpcode() != Opcodes.INVOKESTATIC) l.add(new InsnNode(Opcodes.POP));
                Type rt = Type.getReturnType(mi.desc);
                if (rt.getSort() == Type.LONG) l.add(new InsnNode(Opcodes.LCONST_0));
                else if (rt.getSort() == Type.INT) l.add(new InsnNode(mi.name.equals("arrayIndexScale") ? Opcodes.ICONST_1 : Opcodes.ICONST_0));
                else if (rt.getSort() != Type.VOID) l.add(new InsnNode(Opcodes.ACONST_NULL));
                m.instructions.insertBefore(mi, l);
                m.instructions.remove(mi);
                unsafeCalls++;
                continue;
            }
            if (mi.name.equals("park") || mi.name.equals("unpark")) {
                // -> mcweb/rt/Park.park(Unsafe-less): drop the Unsafe receiver
                String nd = mi.name.equals("park") ? "(ZJ)V" : "(Ljava/lang/Object;)V";
                SourceValue recv = fr[k].getStack(fr[k].getStackSize() - 1 - at.length);
                if (recv.insns.size() == 1 && recv.insns.iterator().next().getOpcode() == Opcodes.GETSTATIC) {
                    m.instructions.set(recv.insns.iterator().next(), new InsnNode(Opcodes.NOP));
                    m.instructions.set(mi, new MethodInsnNode(Opcodes.INVOKESTATIC, "java/util/concurrent/locks/LockSupport", mi.name.equals("park") ? "mcwebPark" : "unpark",
                        mi.name.equals("park") ? nd : "(Ljava/lang/Thread;)V", false));
                    if (!mi.name.equals("park")) m.instructions.insertBefore(m.instructions.get(m.instructions.indexOf(mi)), new TypeInsnNode(Opcodes.CHECKCAST, "java/lang/Thread"));
                    unsafeCalls++;
                }
                continue;
            }
            String op = unsafeOp(mi.name);
            if (op == null || at.length < 2 || at[1].getSort() != Type.LONG) { System.out.println("WARN unsupported Unsafe." + mi.name + " in " + cn.name + "." + m.name); continue; }
            int top = fr[k].getStackSize();
            SourceValue recv = fr[k].getStack(top - 1 - at.length - 0);
            // stack: [U, o, offset(long, 1 slot in frames), rest...]
            SourceValue off = fr[k].getStack(top - at.length + 1);
            AbstractInsnNode ri = recv.insns.size() == 1 ? recv.insns.iterator().next() : null;
            AbstractInsnNode oi = off.insns.size() == 1 ? off.insns.iterator().next() : null;
            if (ri == null || oi == null || ri.getOpcode() != Opcodes.GETSTATIC || oi.getOpcode() != Opcodes.GETSTATIC) {
                System.out.println("WARN Unsafe." + mi.name + " operands not static fields in " + cn.name + "." + m.name); continue;
            }
            String[] fld = offFields.get(((FieldInsnNode) oi).owner + "." + ((FieldInsnNode) oi).name);
            if (fld == null) { System.out.println("WARN unknown offset field " + ((FieldInsnNode) oi).owner + "." + ((FieldInsnNode) oi).name); continue; }
            String fd = fieldDesc(fld[0], fld[1]);
            if (fd == null) { System.out.println("WARN field not found " + fld[0] + "." + fld[1]); continue; }
            // helper desc: drop the long offset
            StringBuilder hd = new StringBuilder("(");
            for (int a2 = 0; a2 < at.length; a2++) if (a2 != 1) hd.append(at[a2].getDescriptor());
            hd.append(")").append(Type.getReturnType(mi.desc).getDescriptor());
            String hname = helperFor(new String[]{"i", fld[0], fld[1], fd}, op, hd.toString());
            if (hname == null) { System.out.println("WARN unsupported Unsafe op " + mi.name); continue; }
            m.instructions.set(ri, new InsnNode(Opcodes.NOP));
            m.instructions.set(oi, new InsnNode(Opcodes.NOP));
            m.instructions.set(mi, new MethodInsnNode(Opcodes.INVOKESTATIC, helper.name, hname, hd.toString(), false));
            unsafeCalls++;
        }
    }

    static boolean isVhFactory(MethodInsnNode mi) {
        return (mi.owner.equals("java/lang/invoke/MethodHandles$Lookup") && (mi.name.equals("findVarHandle") || mi.name.equals("findStaticVarHandle")))
            || (mi.owner.equals("java/lang/invoke/MethodHandles") && mi.name.equals("arrayElementVarHandle"));
    }

    static Type constType(SourceValue v) {
        if (v == null || v.insns.size() != 1) return null;
        AbstractInsnNode i = v.insns.iterator().next();
        if (i instanceof LdcInsnNode && ((LdcInsnNode) i).cst instanceof Type) return (Type) ((LdcInsnNode) i).cst;
        if (i instanceof FieldInsnNode && i.getOpcode() == Opcodes.GETSTATIC && ((FieldInsnNode) i).name.equals("TYPE")) {
            switch (((FieldInsnNode) i).owner) {
                case "java/lang/Integer": return Type.INT_TYPE;
                case "java/lang/Long": return Type.LONG_TYPE;
                case "java/lang/Boolean": return Type.BOOLEAN_TYPE;
                case "java/lang/Byte": return Type.BYTE_TYPE;
                case "java/lang/Short": return Type.SHORT_TYPE;
                case "java/lang/Character": return Type.CHAR_TYPE;
                case "java/lang/Float": return Type.FLOAT_TYPE;
                case "java/lang/Double": return Type.DOUBLE_TYPE;
            }
        }
        return null;
    }

    static String constString(SourceValue v) {
        if (v == null || v.insns.size() != 1) return null;
        AbstractInsnNode i = v.insns.iterator().next();
        return i instanceof LdcInsnNode && ((LdcInsnNode) i).cst instanceof String ? (String) ((LdcInsnNode) i).cst : null;
    }

    // ---------------------------------------------------------------- VarHandle lowering
    static void lowerVarHandles(ClassNode cn, MethodNode m) throws AnalyzerException {
        boolean any = false;
        for (AbstractInsnNode i : m.instructions)
            if (i instanceof MethodInsnNode && (((MethodInsnNode) i).owner.equals("java/lang/invoke/VarHandle") || isVhFactory((MethodInsnNode) i)
                || (((MethodInsnNode) i).owner.equals("java/lang/invoke/MethodHandles") && ((MethodInsnNode) i).name.equals("lookup")))) any = true;
        if (!any) return;
        Frame<SourceValue>[] fr = new Analyzer<>(new SourceInterpreter()).analyze(cn.name, m);
        AbstractInsnNode[] ins = m.instructions.toArray();
        for (int k = 0; k < ins.length; k++) {
            if (!(ins[k] instanceof MethodInsnNode)) continue;
            MethodInsnNode mi = (MethodInsnNode) ins[k];
            if (mi.owner.equals("java/lang/invoke/MethodHandles") && mi.name.equals("lookup")) {
                m.instructions.set(mi, new InsnNode(Opcodes.ACONST_NULL));
                continue;
            }
            if (isVhFactory(mi)) {
                // drop args (and the Lookup receiver), push null
                InsnList l = new InsnList();
                for (Type t : Type.getArgumentTypes(mi.desc)) l.add(new InsnNode(t.getSize() == 2 ? Opcodes.POP2 : Opcodes.POP));
                if (mi.getOpcode() != Opcodes.INVOKESTATIC) l.add(new InsnNode(Opcodes.POP));
                l.add(new InsnNode(Opcodes.ACONST_NULL));
                m.instructions.insertBefore(mi, l);
                m.instructions.remove(mi);
                continue;
            }
            if (!mi.owner.equals("java/lang/invoke/VarHandle") || fr[k] == null) continue;
            if (mi.getOpcode() == Opcodes.INVOKESTATIC) { // fences: fullFence, acquireFence, ...
                m.instructions.remove(mi);
                continue;
            }
            int nargs = Type.getArgumentTypes(mi.desc).length;
            SourceValue recv = fr[k].getStack(fr[k].getStackSize() - 1 - nargs);
            if (recv.insns.size() != 1) { System.out.println("WARN VH receiver not unique in " + cn.name + "." + m.name); continue; }
            AbstractInsnNode src = recv.insns.iterator().next();
            if (!(src instanceof FieldInsnNode) || src.getOpcode() != Opcodes.GETSTATIC) { System.out.println("WARN VH receiver not static field in " + cn.name + "." + m.name); continue; }
            String[] vh = vhFields.get(((FieldInsnNode) src).owner + "." + ((FieldInsnNode) src).name);
            if (vh == null) { System.out.println("WARN unknown VH field " + ((FieldInsnNode) src).owner + "." + ((FieldInsnNode) src).name); continue; }
            String hname = helperFor(vh, mi.name, mi.desc);
            if (hname == null) { System.out.println("WARN unsupported VH op " + mi.name + mi.desc + " in " + cn.name); continue; }
            m.instructions.set(src, new InsnNode(Opcodes.NOP));
            m.instructions.set(mi, new MethodInsnNode(Opcodes.INVOKESTATIC, helper.name, hname, mi.desc, false));
            vhCalls++;
        }
    }

    static String helperFor(String[] vh0, String op, String desc) {
        String[] vh = vh0;
        boolean dropRecv = false;
        if (vh0[0].equals("i") && vh0[1].equals("java/lang/Thread")) { vh = new String[]{"s", "mcweb/rt/ThreadFields", vh0[2], vh0[3]}; dropRecv = true; }
        String key = (op + "$" + vh[0] + "$" + vh[1] + "$" + vh[2]).replaceAll("[^A-Za-z0-9_$]", "_");
        String hname = key + "$" + Integer.toHexString(desc.hashCode());
        if (helperMethods.contains(hname)) return hname;
        Type[] args = Type.getArgumentTypes(desc);
        Type ret = Type.getReturnType(desc);
        Type ft = Type.getType(vh[3]);
        MethodNode m = new MethodNode(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, hname, desc, null, null);
        InsnList l = m.instructions;
        int locals = 0;
        int[] slot = new int[args.length];
        for (int i = 0; i < args.length; i++) { slot[i] = locals; locals += args[i].getSize(); }
        // value args start after receiver (+index for arrays)
        int base = vh[0].equals("s") ? (dropRecv ? 1 : 0) : vh[0].equals("a") ? 2 : 1;
        String kind = op.replaceAll("(Volatile|Acquire|Release|Opaque|Plain)$", "");
        if (kind.startsWith("weakCompareAndSet")) kind = "compareAndSet";
        if (kind.startsWith("compareAndExchange")) kind = "compareAndExchange";
        if (kind.startsWith("getAndSet")) kind = "getAndSet";
        if (kind.startsWith("getAndAdd")) kind = "getAndAdd";
        if (kind.startsWith("getAndBitwiseOr")) kind = "getAndBitwiseOr";
        if (kind.startsWith("getAndBitwiseAnd")) kind = "getAndBitwiseAnd";
        int tmp = locals;  // local for old value
        Runnable[] dummy = null;
        switch (kind) {
            case "get":
                load(l, vh, args, slot); getv(l, vh); conv(l, ft, ret); l.add(new InsnNode(ret.getOpcode(Opcodes.IRETURN)));
                break;
            case "set":
                load(l, vh, args, slot); arg(l, args, slot, base, ft); putv(l, vh); l.add(new InsnNode(Opcodes.RETURN));
                break;
            case "compareAndSet":
            case "compareAndExchange":
            case "getAndSet":
            case "getAndAdd":
            case "getAndBitwiseOr":
            case "getAndBitwiseAnd": {
                // old = get
                load(l, vh, args, slot); getv(l, vh); l.add(new VarInsnNode(ft.getOpcode(Opcodes.ISTORE), tmp));
                LabelNode skip = new LabelNode();
                if (kind.equals("compareAndSet") || kind.equals("compareAndExchange")) {
                    l.add(new VarInsnNode(ft.getOpcode(Opcodes.ILOAD), tmp));
                    arg(l, args, slot, base, ft);
                    cmpNe(l, ft, skip);
                    load(l, vh, args, slot); arg(l, args, slot, base + 1, ft); putv(l, vh);
                    if (kind.equals("compareAndSet")) { l.add(new InsnNode(Opcodes.ICONST_1)); l.add(new InsnNode(Opcodes.IRETURN)); l.add(skip); l.add(new InsnNode(Opcodes.ICONST_0)); l.add(new InsnNode(Opcodes.IRETURN)); }
                    else { l.add(skip); l.add(new VarInsnNode(ft.getOpcode(Opcodes.ILOAD), tmp)); conv(l, ft, ret); l.add(new InsnNode(ret.getOpcode(Opcodes.IRETURN))); }
                } else {
                    load(l, vh, args, slot);
                    if (kind.equals("getAndSet")) arg(l, args, slot, base, ft);
                    else {
                        l.add(new VarInsnNode(ft.getOpcode(Opcodes.ILOAD), tmp)); arg(l, args, slot, base, ft);
                        int op2 = kind.equals("getAndAdd") ? Opcodes.IADD : kind.equals("getAndBitwiseOr") ? Opcodes.IOR : Opcodes.IAND;
                        l.add(new InsnNode(ft.getOpcode(op2)));
                    }
                    putv(l, vh);
                    l.add(new VarInsnNode(ft.getOpcode(Opcodes.ILOAD), tmp)); conv(l, ft, ret); l.add(new InsnNode(ret.getOpcode(Opcodes.IRETURN)));
                }
                break;
            }
            default:
                return null;
        }
        helper.methods.add(m);
        helperMethods.add(hname);
        return hname;
    }

    /** push the receiver (and index) */
    static void load(InsnList l, String[] vh, Type[] args, int[] slot) {
        if (vh[0].equals("i")) { l.add(new VarInsnNode(Opcodes.ALOAD, slot[0])); l.add(new TypeInsnNode(Opcodes.CHECKCAST, vh[1])); }
        else if (vh[0].equals("a")) { l.add(new VarInsnNode(Opcodes.ALOAD, slot[0])); l.add(new TypeInsnNode(Opcodes.CHECKCAST, vh[1])); l.add(new VarInsnNode(Opcodes.ILOAD, slot[1])); }
    }
    static void getv(InsnList l, String[] vh) {
        if (vh[0].equals("i")) l.add(new FieldInsnNode(Opcodes.GETFIELD, vh[1], vh[2], vh[3]));
        else if (vh[0].equals("s")) l.add(new FieldInsnNode(Opcodes.GETSTATIC, vh[1], vh[2], vh[3]));
        else l.add(new InsnNode(Type.getType(vh[3]).getOpcode(Opcodes.IALOAD)));
    }
    static void putv(InsnList l, String[] vh) {
        if (vh[0].equals("i")) l.add(new FieldInsnNode(Opcodes.PUTFIELD, vh[1], vh[2], vh[3]));
        else if (vh[0].equals("s")) l.add(new FieldInsnNode(Opcodes.PUTSTATIC, vh[1], vh[2], vh[3]));
        else l.add(new InsnNode(Type.getType(vh[3]).getOpcode(Opcodes.IASTORE)));
    }
    static void arg(InsnList l, Type[] args, int[] slot, int i, Type ft) {
        l.add(new VarInsnNode(args[i].getOpcode(Opcodes.ILOAD), slot[i]));
        conv(l, args[i], ft);
    }
    static void conv(InsnList l, Type from, Type to) {
        if (to.getSort() == Type.VOID) { l.add(new InsnNode(from.getSize() == 2 ? Opcodes.POP2 : Opcodes.POP)); return; }
        if (to.getSort() == Type.OBJECT || to.getSort() == Type.ARRAY) {
            if (from.getSort() == Type.OBJECT || from.getSort() == Type.ARRAY) { if (!to.getInternalName().equals("java/lang/Object")) l.add(new TypeInsnNode(Opcodes.CHECKCAST, to.getInternalName())); }
            return;
        }
        // primitives: call sites use the field's exact type in practice
    }
    static void cmpNe(InsnList l, Type t, LabelNode target) {
        switch (t.getSort()) {
            case Type.OBJECT: case Type.ARRAY: l.add(new JumpInsnNode(Opcodes.IF_ACMPNE, target)); break;
            case Type.LONG: l.add(new InsnNode(Opcodes.LCMP)); l.add(new JumpInsnNode(Opcodes.IFNE, target)); break;
            case Type.FLOAT: l.add(new InsnNode(Opcodes.FCMPL)); l.add(new JumpInsnNode(Opcodes.IFNE, target)); break;
            case Type.DOUBLE: l.add(new InsnNode(Opcodes.DCMPL)); l.add(new JumpInsnNode(Opcodes.IFNE, target)); break;
            default: l.add(new JumpInsnNode(Opcodes.IF_ICMPNE, target));
        }
    }

    static boolean isJsNativeClass(String n) { for (String p : jsnativePrefixes) if (n.startsWith(p)) return true; return false; }

    static boolean jsPrim(Type t) {
        switch (t.getSort()) { case Type.OBJECT: case Type.ARRAY: case Type.METHOD: return false; default: return true; }
    }

    /**
     * A JNI native method becomes a call to a generated @JSBody stub in mcweb/jsn/N that calls
     * LWJGLWeb.N["Java_<class>_<name>"](null, args...) (the table built by lw-core's buildNatives). Longs (pointers)
     * cross as doubles. Natives with object or array parameters throw at runtime.
     */
    static void bridgeNative(ClassNode cn, MethodNode m) {
        Type[] at = Type.getArgumentTypes(m.desc);
        Type rt = Type.getReturnType(m.desc);
        boolean st = (m.access & Opcodes.ACC_STATIC) != 0;
        boolean ok = st && (rt.getSort() == Type.VOID || jsPrim(rt));
        for (Type t : at) ok &= jsPrim(t);
        m.access &= ~Opcodes.ACC_NATIVE;
        m.instructions.clear();
        m.tryCatchBlocks.clear();
        InsnList l = m.instructions;
        if (!ok) {
            l.add(new LdcInsnNode("native " + cn.name + "." + m.name + m.desc));
            l.add(new MethodInsnNode(Opcodes.INVOKESTATIC, "mcweb/rt/Shim", "unsupportedHandle", "(Ljava/lang/String;)V", false));
            switch (rt.getSort()) {
                case Type.VOID: break;
                case Type.LONG: l.add(new InsnNode(Opcodes.LCONST_0)); break;
                case Type.FLOAT: l.add(new InsnNode(Opcodes.FCONST_0)); break;
                case Type.DOUBLE: l.add(new InsnNode(Opcodes.DCONST_0)); break;
                case Type.OBJECT: case Type.ARRAY: l.add(new InsnNode(Opcodes.ACONST_NULL)); break;
                default: l.add(new InsnNode(Opcodes.ICONST_0));
            }
            l.add(new InsnNode(rt.getOpcode(Opcodes.IRETURN)));
            unsupportedNatives++;
            return;
        }
        StringBuilder hd = new StringBuilder("(");
        List<String> params = new ArrayList<>();
        StringBuilder call = new StringBuilder();
        int slot = 0;
        for (int k = 0; k < at.length; k++) {
            Type t = at[k];
            l.add(new VarInsnNode(t.getOpcode(Opcodes.ILOAD), slot));
            slot += t.getSize();
            if (t.getSort() == Type.LONG) { l.add(new InsnNode(Opcodes.L2D)); hd.append('D'); }
            else if (t.getSort() == Type.BYTE || t.getSort() == Type.SHORT || t.getSort() == Type.CHAR) hd.append('I');
            else hd.append(t.getDescriptor());
            params.add("a" + k);
            call.append(", a").append(k);
        }
        hd.append(')');
        Type hr;
        switch (rt.getSort()) {
            case Type.LONG: hr = Type.DOUBLE_TYPE; break;
            case Type.BYTE: case Type.SHORT: case Type.CHAR: hr = Type.INT_TYPE; break;
            default: hr = rt;
        }
        hd.append(hr.getDescriptor());
        String key = "Java_" + cn.name.replace('/', '_') + "_" + m.name;
        String hname = "n" + jsn.methods.size();
        MethodNode h = new MethodNode(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC | Opcodes.ACC_NATIVE, hname, hd.toString(), null, null);
        AnnotationNode an = new AnnotationNode("Lorg/teavm/jso/JSBody;");
        an.values = new ArrayList<>(Arrays.asList("params", params, "script",
            (rt.getSort() == Type.VOID ? "" : "return ") + "LWJGLWeb.N[\"" + key + "\"](null" + call + ");"));
        h.visibleAnnotations = new ArrayList<>(Collections.singletonList(an));
        jsn.methods.add(h);
        l.add(new MethodInsnNode(Opcodes.INVOKESTATIC, jsn.name, hname, hd.toString(), false));
        switch (rt.getSort()) {
            case Type.LONG: l.add(new InsnNode(Opcodes.D2L)); break;
            case Type.BYTE: l.add(new InsnNode(Opcodes.I2B)); break;
            case Type.SHORT: l.add(new InsnNode(Opcodes.I2S)); break;
            case Type.CHAR: l.add(new InsnNode(Opcodes.I2C)); break;
            default:
        }
        l.add(new InsnNode(rt.getOpcode(Opcodes.IRETURN)));
        nativeRows.add("[\"" + cn.name + "\",\"" + m.name + "\",\"" + m.desc + "\"]");
    }

    static int unsupportedCalls = 0;
    /** VarHandle / MethodHandle signature-polymorphic calls that survived lowering: pop operands, throw, push default. */
    static void unsupportedHandles(MethodNode m) {
        for (AbstractInsnNode i : m.instructions.toArray()) {
            if (!(i instanceof MethodInsnNode)) continue;
            MethodInsnNode mi = (MethodInsnNode) i;
            boolean poly = (mi.owner.equals("java/lang/invoke/VarHandle") && mi.getOpcode() == Opcodes.INVOKEVIRTUAL)
                || (mi.owner.equals("java/lang/invoke/MethodHandle") && (mi.name.equals("invokeExact") || mi.name.equals("invoke")));
            if (!poly) continue;
            InsnList l = new InsnList();
            Type[] at = Type.getArgumentTypes(mi.desc);
            for (int k = at.length - 1; k >= 0; k--) l.add(new InsnNode(at[k].getSize() == 2 ? Opcodes.POP2 : Opcodes.POP));
            l.add(new InsnNode(Opcodes.POP));
            l.add(new LdcInsnNode(mi.owner + "." + mi.name + mi.desc));
            l.add(new MethodInsnNode(Opcodes.INVOKESTATIC, "mcweb/rt/Shim", "unsupportedHandle", "(Ljava/lang/String;)V", false));
            Type rt = Type.getReturnType(mi.desc);
            switch (rt.getSort()) {
                case Type.VOID: break;
                case Type.LONG: l.add(new InsnNode(Opcodes.LCONST_0)); break;
                case Type.FLOAT: l.add(new InsnNode(Opcodes.FCONST_0)); break;
                case Type.DOUBLE: l.add(new InsnNode(Opcodes.DCONST_0)); break;
                case Type.OBJECT: case Type.ARRAY: l.add(new InsnNode(Opcodes.ACONST_NULL)); break;
                default: l.add(new InsnNode(Opcodes.ICONST_0));
            }
            m.instructions.insertBefore(mi, l);
            m.instructions.remove(mi);
            unsupportedCalls++;
        }
    }

    static int bodiesReplaced = 0;
    static void replaceBody(ClassNode cn, MethodNode m, String tgt) {
        m.instructions.clear();
        m.tryCatchBlocks.clear();
        if (m.localVariables != null) m.localVariables.clear();
        m.access &= ~(Opcodes.ACC_NATIVE | Opcodes.ACC_ABSTRACT);
        Type rt = Type.getReturnType(m.desc);
        InsnList l = m.instructions;
        if (tgt.equals("default")) {
            switch (rt.getSort()) {
                case Type.VOID: break;
                case Type.LONG: l.add(new InsnNode(Opcodes.LCONST_0)); break;
                case Type.FLOAT: l.add(new InsnNode(Opcodes.FCONST_0)); break;
                case Type.DOUBLE: l.add(new InsnNode(Opcodes.DCONST_0)); break;
                case Type.OBJECT: case Type.ARRAY: l.add(new InsnNode(Opcodes.ACONST_NULL)); break;
                default: l.add(new InsnNode(Opcodes.ICONST_0));
            }
        } else {
            boolean st = (m.access & Opcodes.ACC_STATIC) != 0;
            int slot = 0;
            if (!st) { l.add(new VarInsnNode(Opcodes.ALOAD, 0)); slot = 1; }
            for (Type t : Type.getArgumentTypes(m.desc)) { l.add(new VarInsnNode(t.getOpcode(Opcodes.ILOAD), slot)); slot += t.getSize(); }
            int d = tgt.lastIndexOf('.');
            String desc = st ? m.desc : "(L" + cn.name + ";" + m.desc.substring(1);
            l.add(new MethodInsnNode(Opcodes.INVOKESTATIC, tgt.substring(0, d), tgt.substring(d + 1), desc, false));
        }
        l.add(new InsnNode(rt.getOpcode(Opcodes.IRETURN)));
        m.maxLocals = Math.max(m.maxLocals, 1);
        bodiesReplaced++;
    }

    // ---------------------------------------------------------------- call / ctor redirects
    static void redirect(MethodNode m) {
        for (AbstractInsnNode i : m.instructions.toArray()) {
            if (i instanceof InvokeDynamicInsnNode) {
                Object[] ba = ((InvokeDynamicInsnNode) i).bsmArgs;
                for (int k = 0; k < ba.length; k++) {
                    if (!(ba[k] instanceof Handle)) continue;
                    Handle h = (Handle) ba[k];
                    if (h.getTag() == Opcodes.H_NEWINVOKESPECIAL || h.getTag() > Opcodes.H_INVOKEINTERFACE || h.getTag() < Opcodes.H_INVOKEVIRTUAL) continue;
                    String[] t = calls.get(h.getOwner() + "." + h.getName() + h.getDesc());
                    if (t == null) t = calls.get(h.getOwner() + "." + h.getName());
                    if (t == null) continue;
                    String desc = h.getTag() == Opcodes.H_INVOKESTATIC ? h.getDesc() : "(L" + h.getOwner() + ";" + h.getDesc().substring(1);
                    ba[k] = new Handle(Opcodes.H_INVOKESTATIC, t[0], t[1], desc, false);
                    redirected++;
                }
                continue;
            }
            if (!(i instanceof MethodInsnNode)) continue;
            MethodInsnNode mi = (MethodInsnNode) i;
            if (mi.name.equals("<init>")) {
                int[] keep = ctors.get(mi.owner + mi.desc);
                if (keep == null) continue;
                Type[] args = Type.getArgumentTypes(mi.desc);
                InsnList l = new InsnList();
                int[] slot = new int[args.length];
                int next = m.maxLocals;
                for (int k = 0; k < args.length; k++) { slot[k] = next; next += args[k].getSize(); }
                for (int k = args.length - 1; k >= 0; k--) l.add(new VarInsnNode(args[k].getOpcode(Opcodes.ISTORE), slot[k]));
                StringBuilder nd = new StringBuilder("(");
                for (int k : keep) { l.add(new VarInsnNode(args[k].getOpcode(Opcodes.ILOAD), slot[k])); nd.append(args[k].getDescriptor()); }
                nd.append(")V");
                m.maxLocals = next;
                m.instructions.insertBefore(mi, l);
                mi.desc = nd.toString();
                redirected++;
                continue;
            }
            String[] t = calls.get(mi.owner + "." + mi.name + mi.desc);
            if (t == null) t = calls.get(mi.owner + "." + mi.name);
            if (t == null) continue;
            String desc = mi.getOpcode() == Opcodes.INVOKESTATIC ? mi.desc : "(L" + mi.owner + ";" + mi.desc.substring(1);
            m.instructions.set(mi, new MethodInsnNode(Opcodes.INVOKESTATIC, t[0], t[1], desc, false));
            redirected++;
        }
    }
}
