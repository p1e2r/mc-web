package mcweb.rt;

import java.util.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

/** mc-web: replacements for JDK methods TeaVM's class library lacks; call sites are redirected here by the patcher (MIT License). */
public final class Shim {
    private Shim() { }

    // Thread
    public static void threadOnSpinWait() { Thread.yield(); }
    public static boolean threadIsVirtual(Thread t) { return false; }
    public static void threadSetContextClassLoader(Thread t, ClassLoader cl) { }
    public static long threadThreadId(Thread t) { return t.getId(); }
    public static void threadDumpStack() { new Exception("Stack trace").printStackTrace(); }

    // System / Runtime
    public static void systemExit(int code) { throw new Error("System.exit(" + code + ")"); }
    public static String systemMapLibraryName(String n) { return "lib" + n + ".so"; }
    public static void systemLoadLibrary(String n) { }
    public static void systemLoad(String n) { }
    public static Map<String, String> systemGetenv() { return Collections.emptyMap(); }
    public static void runtimeAddShutdownHook(Runtime r, Thread t) { }
    public static boolean runtimeRemoveShutdownHook(Runtime r, Thread t) { return true; }
    public static long runtimeMaxMemory(Runtime r) { return 2048L << 20; }

    // Character / String / numbers
    public static String characterToString(int cp) { return new String(Character.toChars(cp)); }
    public static int characterCodePointOf(String name) { throw new IllegalArgumentException("Unknown character name: " + name); }
    public static StringBuilder stringBuilderAppendByte(StringBuilder sb, byte b) { return sb.append((int) b); }
    public static float mathFma(float a, float b, float c) { return (float) ((double) a * b + c); }
    public static int integerParseUnsignedInt(String s, int radix) {
        long v = Long.parseLong(s, radix);
        if (v < 0 || v > 0xFFFFFFFFL) throw new NumberFormatException(s);
        return (int) v;
    }
    public static long longParseUnsignedLong(String s, int radix) {
        if (s.length() < 16 || radix != 16) return Long.parseLong(s, radix);
        // split to avoid overflow in hex
        long hi = Long.parseLong(s.substring(0, s.length() - 8), 16), lo = Long.parseLong(s.substring(s.length() - 8), 16);
        return (hi << 32) | lo;
    }

    // regex
    public static Predicate<String> patternAsPredicate(Pattern p) { return s -> p.matcher(s).find(); }
    public static Matcher matcherAppendReplacement(Matcher m, StringBuilder sb, String rep) {
        StringBuffer b = new StringBuffer();
        m.appendReplacement(b, rep);
        sb.append(b);
        return m;
    }
    public static StringBuilder matcherAppendTail(Matcher m, StringBuilder sb) {
        StringBuffer b = new StringBuffer();
        m.appendTail(b);
        return sb.append(b);
    }

    // collections / streams
    public static <T> SortedSet<T> collectionsUnmodifiableSortedSet(SortedSet<T> s) { return s; }
    public static <K, V> SortedMap<K, V> collectionsUnmodifiableSortedMap(SortedMap<K, ? extends V> m) { @SuppressWarnings("unchecked") SortedMap<K, V> r = (SortedMap<K, V>) m; return r; }
    public static <T> Stream<T> streamOfNullable(T t) { return t == null ? Stream.empty() : Stream.of(t); }
    public static IntStream streamSupportIntStream(Spliterator.OfInt s, boolean parallel) {
        IntStream.Builder b = IntStream.builder();
        s.forEachRemaining((IntConsumer) b::add);
        return b.build();
    }
    public static LongStream streamSupportLongStream(Spliterator.OfLong s, boolean parallel) {
        LongStream.Builder b = LongStream.builder();
        s.forEachRemaining((LongConsumer) b::add);
        return b.build();
    }
    public static void referenceReachabilityFence(Object o) { }

    // Class
    public static boolean classIsRecord(Class<?> c) { return false; }
    public static boolean classIsHidden(Class<?> c) { return false; }
    public static boolean classIsAnonymousClass(Class<?> c) { return c.getSimpleName().isEmpty(); }
    public static String classGetPackageName(Class<?> c) {
        String n = c.getName();
        int i = n.lastIndexOf('.');
        return i < 0 ? "" : n.substring(0, i);
    }
    public static java.lang.reflect.Type classGetGenericSuperclass(Class<?> c) { return Generics.genericSuperclass(c); }
    public static java.lang.reflect.Type[] classGetGenericInterfaces(Class<?> c) { return Generics.genericInterfaces(c); }
    public static java.net.URL classGetResource(Class<?> c, String name) { return null; }
    public static java.net.URL classLoaderGetResource(ClassLoader cl, String name) { return null; }
    public static Enumeration<java.net.URL> classLoaderGetResources(ClassLoader cl, String name) { return Collections.emptyEnumeration(); }
    public static Class<?> classLoaderLoadClass(ClassLoader cl, String name) throws ClassNotFoundException { return Class.forName(name); }

    public static mcweb.rt.FakeModule classGetModule(Class<?> c) { return new mcweb.rt.FakeModule(); }
    public static Object[] classGetSigners(Class<?> c) { return null; }
    public static java.net.URL classLoaderGetSystemResource(String name) { return null; }
    public static int tlrNextSecondarySeed() {
        int r = ThreadFields.threadLocalRandomSecondarySeed;
        r ^= r << 13; r ^= r >>> 17; r ^= r << 5;
        return ThreadFields.threadLocalRandomSecondarySeed = r;
    }
    public static java.nio.file.Path fileToPath(java.io.File f) { return java.nio.file.Paths.get(f.getPath()); }
    public static String filesProbeContentType(java.nio.file.Path p) { return null; }
    public static java.nio.file.FileStore filesGetFileStore(java.nio.file.Path p) throws java.io.IOException { throw new java.io.IOException("no file stores in the browser"); }
    public static boolean charsetIsSupported(String name) {
        try { java.nio.charset.Charset.forName(name); return true; } catch (RuntimeException e) { return false; }
    }

    /** Target of VarHandle / MethodHandle call sites the patcher could not lower. */
    public static void unsupportedHandle(String what) { throw new UnsupportedOperationException("not supported in the browser: " + what); }
    public static boolean alwaysFalse() { return false; }
    public static boolean alwaysTrue() { return true; }

    public static java.lang.invoke.MethodHandles.Lookup privateLookupIn(Class<?> c, java.lang.invoke.MethodHandles.Lookup l) { return null; }
    public static <T> List<T> emptyList() { return Collections.emptyList(); }
    public static <T> Optional<T> emptyOptionalS(String s) { return Optional.empty(); }
    public static String lwjglVersion() { return "3.4.1 mc-web"; }

    // round 4 additions
    public static long readerTransferTo(java.io.Reader r, java.io.Writer w) throws java.io.IOException {
        char[] b = new char[8192]; long t = 0; int n;
        while ((n = r.read(b)) >= 0) { w.write(b, 0, n); t += n; }
        return t;
    }
    public static long bufferedReaderTransferTo(java.io.BufferedReader r, java.io.Writer w) throws java.io.IOException { return readerTransferTo(r, w); }
    public static double mathFmaD(double a, double b, double c) { return a * b + c; }
    public static Process runtimeExec(Runtime r, String[] cmd) throws java.io.IOException { throw new java.io.IOException("processes are not available in the browser"); }
    public static Process runtimeExec1(Runtime r, String cmd) throws java.io.IOException { throw new java.io.IOException("processes are not available in the browser"); }
    public static Stream<String> stringLines(String s) { return s.isEmpty() ? Stream.empty() : Arrays.stream(s.split("\\R")); }
    public static StringBuilder stringBuilderAppendShort(StringBuilder sb, short v) { return sb.append((int) v); }
    public static Thread.State threadGetState(Thread t) { return t.isAlive() ? Thread.State.RUNNABLE : Thread.State.TERMINATED; }
    /** Thread.interrupt must also wake a thread blocked in LockSupport.park (our park doesn't hook TeaVM's interrupt handler). */
    public static void threadInterrupt(Thread t) {
        t.interrupt();
        java.util.concurrent.locks.LockSupport.unpark(t);
    }
    public static void threadSleep2(long ms, int nanos) throws InterruptedException { Thread.sleep(ms); }
    public static Object arrayNewInstanceMulti(Class<?> c, int[] dims) {
        Object a = java.lang.reflect.Array.newInstance(dims.length > 1 ? Object.class : c, dims[0]);
        if (dims.length > 1) { int[] rest = Arrays.copyOfRange(dims, 1, dims.length); for (int i = 0; i < dims[0]; i++) ((Object[]) a)[i] = arrayNewInstanceMulti(c, rest); }
        return a;
    }
    public static long httpContentLengthLong(java.net.HttpURLConnection c) { return c.getContentLength(); }
    public static java.net.URLConnection urlOpenConnectionProxy(java.net.URL u, java.net.Proxy p) throws java.io.IOException { return u.openConnection(); }
    public static java.nio.ByteBuffer byteBufferSlice(java.nio.ByteBuffer b, int index, int length) {
        java.nio.ByteBuffer d = b.duplicate(); d.limit(index + length); d.position(index); return d.slice().order(b.order());
    }
    public static java.nio.file.WatchService fsNewWatchService(java.nio.file.FileSystem fs) throws java.io.IOException { throw new UnsupportedOperationException("file watching is not available in the browser"); }
    public static java.nio.file.Path filesCreateLink(java.nio.file.Path link, java.nio.file.Path existing) throws java.io.IOException { java.nio.file.Files.copy(existing, link); return link; }
    public static Set<Object> filesGetPosixFilePermissions(java.nio.file.Path p, java.nio.file.LinkOption... o) throws java.io.IOException { throw new UnsupportedOperationException("posix permissions"); }
    public static java.nio.file.Path filesSetPosixFilePermissions(java.nio.file.Path p, Set<?> perms) { return p; }
    public static java.nio.file.Path filesSetLastModifiedTime(java.nio.file.Path p, java.nio.file.attribute.FileTime t) { return p; }
    public static java.nio.channels.SeekableByteChannel filesNewByteChannel(java.nio.file.Path p, Set<? extends java.nio.file.OpenOption> o, java.nio.file.attribute.FileAttribute<?>... a) throws java.io.IOException {
        return java.nio.channels.FileChannel.open(p, o.toArray(new java.nio.file.OpenOption[0]));
    }
    public static long durationToSeconds(java.time.Duration d) { return d.getSeconds(); }
    public static Base64.Decoder base64MimeDecoder() { return Base64.getDecoder(); }
    public static Base64.Encoder base64MimeEncoder(int len, byte[] sep) { return Base64.getEncoder(); }
    public static String localeGetISO3Country(Locale l) { return ""; }
    public static <T> Spliterator<T> spliteratorsEmpty() { return Collections.<T>emptyList().spliterator(); }
    public static <T> Iterator<T> spliteratorsIterator(Spliterator<? extends T> s) {
        List<T> l = new ArrayList<>(); s.forEachRemaining(l::add); return l.iterator();
    }
    public static PrimitiveIterator.OfInt spliteratorsIteratorInt(Spliterator.OfInt s) {
        IntStream.Builder b = IntStream.builder(); s.forEachRemaining((IntConsumer) b::add); return b.build().iterator();
    }
    public static Spliterator.OfDouble spliteratorsDoubleArray(double[] a, int from, int to, int ch) { return Arrays.stream(a, from, to).spliterator(); }
    public static <K> mcweb.rt.KeySetView<K> chmNewKeySet() { return new mcweb.rt.KeySetView<>(); }
    public static long timeUnitConvertDuration(java.util.concurrent.TimeUnit u, java.time.Duration d) { return u.convert(d.toNanos(), java.util.concurrent.TimeUnit.NANOSECONDS); }
    // Minecraft's packet decompression (CompressionDecoder) hands the whole compressed packet to setInput(ByteBuffer)
    // and asks for the whole result in one inflate(ByteBuffer). TeaVM's Inflater is zlib compiled from Java; fflate
    // (JavaScript) is much faster, so the pair is done in one fflate call. The Inflater still gets the input, so any
    // other caller pattern (or corrupt data) falls back to it.
    private static final java.util.Map<java.util.zip.Inflater, byte[]> INFLATE_INPUT = new java.util.IdentityHashMap<>();
    public static int inflaterInflateBB(java.util.zip.Inflater inf, java.nio.ByteBuffer out) throws java.util.zip.DataFormatException {
        byte[] src = INFLATE_INPUT.remove(inf);
        if (src != null) {
            try {
                byte[] r = mcweb.rt.zip.JsZ.decompress(mcweb.rt.zip.JsZ.ZLIB, src, src.length);
                if (r.length <= out.remaining()) { out.put(r); return r.length; }
            } catch (java.io.IOException e) {
                // fall through to the Inflater, which reports the error the way the game expects
            }
        }
        byte[] tmp = new byte[out.remaining()]; int n = inf.inflate(tmp); out.put(tmp, 0, n); return n;
    }
    public static void inflaterSetInputBB(java.util.zip.Inflater inf, java.nio.ByteBuffer in) {
        byte[] tmp = new byte[in.remaining()]; in.get(tmp); inf.setInput(tmp);
        INFLATE_INPUT.put(inf, tmp);
    }
    public static java.lang.invoke.MethodType methodType(Class<?> r) { throw new UnsupportedOperationException("MethodType"); }
    public static java.lang.invoke.MethodType methodType(Class<?> r, Class<?> p) { throw new UnsupportedOperationException("MethodType"); }
    public static java.lang.invoke.MethodType methodType(Class<?> r, Class<?> p, Class<?>... ps) { throw new UnsupportedOperationException("MethodType"); }
    public static java.lang.invoke.MethodHandles.Lookup publicLookup() { return null; }
    public static java.lang.invoke.MethodHandle lookupUnreflect(java.lang.invoke.MethodHandles.Lookup l, java.lang.reflect.Method m) throws IllegalAccessException { throw new UnsupportedOperationException("unreflect"); }
    public static java.lang.invoke.MethodHandle lookupUnreflectConstructor(java.lang.invoke.MethodHandles.Lookup l, java.lang.reflect.Constructor<?> c) throws IllegalAccessException { throw new UnsupportedOperationException("unreflectConstructor"); }
    public static java.lang.invoke.MethodHandle methodHandleBindTo(java.lang.invoke.MethodHandle h, Object o) { throw new UnsupportedOperationException("bindTo"); }

    public static java.lang.invoke.MethodHandle methodHandleAsType(java.lang.invoke.MethodHandle h, java.lang.invoke.MethodType t) { throw new UnsupportedOperationException("asType"); }
    public static java.lang.invoke.MethodHandle lookupFindStatic(java.lang.invoke.MethodHandles.Lookup l, Class<?> c, String n, java.lang.invoke.MethodType t) throws NoSuchMethodException { throw new NoSuchMethodException(n); }
    public static java.lang.invoke.MethodHandle lookupFindVirtual(java.lang.invoke.MethodHandles.Lookup l, Class<?> c, String n, java.lang.invoke.MethodType t) throws NoSuchMethodException { throw new NoSuchMethodException(n); }
    public static String filesReadString(java.nio.file.Path p) throws java.io.IOException { return new String(java.nio.file.Files.readAllBytes(p), java.nio.charset.StandardCharsets.UTF_8); }
    public static String filesReadString2(java.nio.file.Path p, java.nio.charset.Charset cs) throws java.io.IOException { return new String(java.nio.file.Files.readAllBytes(p), cs); }
    public static java.nio.file.attribute.FileAttributeView filesGetFileAttributeView(java.nio.file.Path p, Class<?> c, java.nio.file.LinkOption... o) { return null; }
    /** FileSystem.getPathMatcher: "glob:" and "regex:" syntaxes */
    public static java.nio.file.PathMatcher fsGetPathMatcher(java.nio.file.FileSystem fs, String spec) {
        int i = spec.indexOf(':');
        String syntax = spec.substring(0, i), pat = spec.substring(i + 1);
        String regex;
        if (syntax.equals("regex")) regex = pat;
        else {
            StringBuilder r = new StringBuilder();
            for (int k = 0; k < pat.length(); k++) {
                char c = pat.charAt(k);
                if (c == '*') { if (k + 1 < pat.length() && pat.charAt(k + 1) == '*') { r.append(".*"); k++; } else r.append("[^/]*"); }
                else if (c == '?') r.append("[^/]");
                else if ("\\.[]{}()+-^$|".indexOf(c) >= 0) r.append('\\').append(c);
                else r.append(c);
            }
            regex = r.toString();
        }
        Pattern rp = Pattern.compile(regex);
        return path -> rp.matcher(path.toString()).matches();
    }

    public static java.nio.channels.FileChannel fisGetChannel(java.io.FileInputStream in) {
        return (java.nio.channels.FileChannel) (Object) org.teavm.classlib.java.nio.channels.TFileChannel.forStream(in, null);
    }
    public static java.nio.channels.FileChannel fosGetChannel(java.io.FileOutputStream out) {
        return (java.nio.channels.FileChannel) (Object) org.teavm.classlib.java.nio.channels.TFileChannel.forStream(null, out);
    }

    public static <T> SequencedSet<T> collectionsUnmodifiableSequencedSet(SequencedSet<? extends T> s) { @SuppressWarnings("unchecked") SequencedSet<T> r = (SequencedSet<T>) s; return r; }
    public static java.nio.file.Path pathResolve2(java.nio.file.Path p, String first, String... more) {
        java.nio.file.Path r = p.resolve(first);
        for (String m : more) r = r.resolve(m);
        return r;
    }
    public static void threadSleepDuration(java.time.Duration d) throws InterruptedException { Thread.sleep(d.toMillis()); }
    public static String readerReadAllAsString(java.io.Reader r) throws java.io.IOException {
        StringBuilder sb = new StringBuilder(); char[] b = new char[8192]; int n;
        while ((n = r.read(b)) >= 0) sb.append(b, 0, n);
        return sb.toString();
    }

    /** org.joml.Options.decimalFormat: TeaVM's DecimalFormat rejects JOML's " 0.000E0;-" pattern */
    public static java.text.NumberFormat jomlDecimalFormat() { return new java.text.DecimalFormat("0.000"); }

    // ---- regex: TeaVM's java.util.regex lacks \h and \H
    private static final String H = " \\t\\u00A0\\u1680\\u180e\\u2000-\\u200a\\u202f\\u205f\\u3000";
    private static final String V = "\\n\\x0B\\f\\r\\u0085\\u2028\\u2029";
    public static String fixRegex(String re) {
        if (re.indexOf("\\h") < 0 && re.indexOf("\\H") < 0 && re.indexOf("\\v") < 0 && re.indexOf("\\V") < 0) return re;
        StringBuilder b = new StringBuilder(re.length() + 32);
        boolean inClass = false;
        for (int i = 0; i < re.length(); i++) {
            char c = re.charAt(i);
            if (c == '\\' && i + 1 < re.length()) {
                char n = re.charAt(i + 1);
                if (n == 'h') { b.append(inClass ? H : "[" + H + "]"); i++; continue; }
                if (n == 'H') { b.append(inClass ? "&&[^" + H + "]" : "[^" + H + "]"); i++; continue; }
                if (n == 'v') { b.append(inClass ? V : "[" + V + "]"); i++; continue; }
                if (n == 'V') { b.append(inClass ? "&&[^" + V + "]" : "[^" + V + "]"); i++; continue; }
                b.append(c).append(n); i++; continue;
            }
            if (c == '[') inClass = true;
            else if (c == ']') inClass = false;
            b.append(c);
        }
        return b.toString();
    }
    public static Pattern patternCompile(String re) { return Pattern.compile(fixRegex(re)); }
    public static Pattern patternCompile2(String re, int flags) { return Pattern.compile(fixRegex(re), flags); }
    public static boolean patternMatches(String re, CharSequence in) { return Pattern.matches(fixRegex(re), in); }
    public static boolean stringMatches(String s, String re) { return s.matches(fixRegex(re)); }
    public static String stringReplaceAll(String s, String re, String rep) { return s.replaceAll(fixRegex(re), rep); }
    public static String stringReplaceFirst(String s, String re, String rep) { return s.replaceFirst(fixRegex(re), rep); }
    public static String[] stringSplit(String s, String re) { return s.split(fixRegex(re)); }
    public static String[] stringSplit2(String s, String re, int limit) { return s.split(fixRegex(re), limit); }

    // ---- Files.walk / Files.find: TeaVM's versions break on nested streams
    private static void walkInto(java.nio.file.Path p, int depth, int max, List<java.nio.file.Path> out) throws java.io.IOException {
        out.add(p);
        if (depth >= max || !java.nio.file.Files.isDirectory(p)) return;
        List<java.nio.file.Path> kids = new ArrayList<>();
        try (java.nio.file.DirectoryStream<java.nio.file.Path> ds = java.nio.file.Files.newDirectoryStream(p)) {
            for (java.nio.file.Path c : ds) kids.add(c);
        }
        for (java.nio.file.Path c : kids) walkInto(c, depth + 1, max, out);
    }
    public static Stream<java.nio.file.Path> filesWalk(java.nio.file.Path start, java.nio.file.FileVisitOption... o) throws java.io.IOException {
        return filesWalk2(start, Integer.MAX_VALUE, o);
    }
    public static Stream<java.nio.file.Path> filesWalk2(java.nio.file.Path start, int maxDepth, java.nio.file.FileVisitOption... o) throws java.io.IOException {
        if (!java.nio.file.Files.exists(start)) throw new java.nio.file.NoSuchFileException(start.toString());
        List<java.nio.file.Path> out = new ArrayList<>();
        walkInto(start, 0, maxDepth, out);
        return out.stream();
    }
    public static Stream<java.nio.file.Path> filesFind(java.nio.file.Path start, int maxDepth,
            java.util.function.BiPredicate<java.nio.file.Path, java.nio.file.attribute.BasicFileAttributes> matcher, java.nio.file.FileVisitOption... o) throws java.io.IOException {
        List<java.nio.file.Path> all = new ArrayList<>();
        walkInto(start, 0, maxDepth, all);
        List<java.nio.file.Path> out = new ArrayList<>();
        for (java.nio.file.Path p : all) {
            java.nio.file.attribute.BasicFileAttributes a = java.nio.file.Files.readAttributes(p, java.nio.file.attribute.BasicFileAttributes.class);
            if (matcher.test(p, a)) out.add(p);
        }
        return out.stream();
    }
    public static Stream<java.nio.file.Path> filesList(java.nio.file.Path dir) throws java.io.IOException {
        List<java.nio.file.Path> out = new ArrayList<>();
        try (java.nio.file.DirectoryStream<java.nio.file.Path> ds = java.nio.file.Files.newDirectoryStream(dir)) {
            for (java.nio.file.Path c : ds) out.add(c);
        }
        return out.stream();
    }

    // time
    public static java.time.Instant dateToInstant(Date d) { return java.time.Instant.ofEpochMilli(d.getTime()); }
    public static Date dateFrom(java.time.Instant i) { return new Date(i.toEpochMilli()); }
}
