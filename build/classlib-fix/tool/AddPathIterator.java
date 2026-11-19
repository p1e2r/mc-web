import java.nio.file.*;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

/** Adds `default Iterator iterator()` to TeaVM's TPath (missing; the JDK has it). */
public class AddPathIterator {
    public static void main(String[] a) throws Exception {
        ClassNode cn = new ClassNode();
        new ClassReader(Files.readAllBytes(Paths.get(a[0]))).accept(cn, 0);
        for (MethodNode m : cn.methods) if (m.name.equals("iterator")) { System.out.println("already present"); return; }
        MethodNode m = new MethodNode(Opcodes.ACC_PUBLIC, "iterator", "()Ljava/util/Iterator;", null, null);
        InsnList l = m.instructions;
        l.add(new TypeInsnNode(Opcodes.NEW, "org/teavm/classlib/java/nio/file/TPathIter"));
        l.add(new InsnNode(Opcodes.DUP));
        l.add(new VarInsnNode(Opcodes.ALOAD, 0));
        l.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, "org/teavm/classlib/java/nio/file/TPathIter", "<init>", "(Lorg/teavm/classlib/java/nio/file/TPath;)V", false));
        l.add(new InsnNode(Opcodes.ARETURN));
        m.maxStack = 3; m.maxLocals = 1;
        cn.methods.add(m);
        ClassWriter cw = new ClassWriter(0);
        cn.accept(cw);
        Files.write(Paths.get(a[1]), cw.toByteArray());
        System.out.println("added iterator()");
    }
}
