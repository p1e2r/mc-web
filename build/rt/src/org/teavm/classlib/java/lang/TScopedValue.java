package org.teavm.classlib.java.lang;
/** mc-web: java.lang.ScopedValue for green threads: bindings are saved and restored around run/call (MIT License). */
public final class TScopedValue<T> {
    private static final Object UNBOUND = new Object();
    private Object value = UNBOUND;
    private TScopedValue() { }
    public static <T> TScopedValue<T> newInstance() { return new TScopedValue<>(); }
    public static <T> TScopedValue$Carrier where(TScopedValue<T> key, T value) { return new TScopedValue$Carrier(null, key, value); }
    @SuppressWarnings("unchecked")
    public T get() { if (value == UNBOUND) throw new java.util.NoSuchElementException("ScopedValue not bound"); return (T) value; }
    public boolean isBound() { return value != UNBOUND; }
    @SuppressWarnings("unchecked") public T orElse(T other) { return value == UNBOUND ? other : (T) value; }
    Object swap(Object v) { Object o = value; value = v; return o; }
}
