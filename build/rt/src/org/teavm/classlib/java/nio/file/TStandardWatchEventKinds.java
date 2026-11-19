package org.teavm.classlib.java.nio.file;
/** mc-web (MIT License). */
public final class TStandardWatchEventKinds {
    private static <T> TWatchEvent.Kind<T> kind(String n, Class<T> c) { return new TWatchEvent.Kind<T>() { public String name() { return n; } public Class<T> type() { return c; } }; }
    public static final TWatchEvent.Kind<Object> OVERFLOW = kind("OVERFLOW", Object.class);
    public static final TWatchEvent.Kind<java.nio.file.Path> ENTRY_CREATE = kind("ENTRY_CREATE", java.nio.file.Path.class);
    public static final TWatchEvent.Kind<java.nio.file.Path> ENTRY_DELETE = kind("ENTRY_DELETE", java.nio.file.Path.class);
    public static final TWatchEvent.Kind<java.nio.file.Path> ENTRY_MODIFY = kind("ENTRY_MODIFY", java.nio.file.Path.class);
}
