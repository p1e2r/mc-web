package org.teavm.classlib.java.lang;
/** mc-web: ScopedValue.Carrier (MIT License). */
public final class TScopedValue$Carrier {
    private final TScopedValue$Carrier prev;
    private final TScopedValue<?> key;
    private final Object value;
    TScopedValue$Carrier(TScopedValue$Carrier prev, TScopedValue<?> key, Object value) { this.prev = prev; this.key = key; this.value = value; }
    public <T> TScopedValue$Carrier where(TScopedValue<T> k, T v) { return new TScopedValue$Carrier(this, k, v); }
    public void run(Runnable op) {
        java.util.ArrayList<Object> saved = new java.util.ArrayList<>();
        for (TScopedValue$Carrier c = this; c != null; c = c.prev) saved.add(c.key.swap(c.value));
        try { op.run(); }
        finally { int i = 0; for (TScopedValue$Carrier c = this; c != null; c = c.prev) c.key.swap(saved.get(i++)); }
    }
}
