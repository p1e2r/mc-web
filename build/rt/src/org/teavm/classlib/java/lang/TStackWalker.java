package org.teavm.classlib.java.lang;
/** mc-web: StackWalker without stack inspection (MIT License). */
public final class TStackWalker {
    public enum Option { RETAIN_CLASS_REFERENCE, SHOW_REFLECT_FRAMES, SHOW_HIDDEN_FRAMES }
    private static final TStackWalker INSTANCE = new TStackWalker();
    public static TStackWalker getInstance() { return INSTANCE; }
    public static TStackWalker getInstance(Option o) { return INSTANCE; }
    public static TStackWalker getInstance(java.util.Set<Option> o) { return INSTANCE; }
    public static TStackWalker getInstance(java.util.Set<Option> o, int depth) { return INSTANCE; }
    public static TStackWalker getInstance(Option o, int depth) { return INSTANCE; }
    public Class<?> getCallerClass() { return Object.class; }
    public <T> T walk(java.util.function.Function<? super java.util.stream.Stream<Object>, ? extends T> f) { return f.apply(java.util.stream.Stream.empty()); }
    public void forEach(java.util.function.Consumer<Object> c) { }
}
