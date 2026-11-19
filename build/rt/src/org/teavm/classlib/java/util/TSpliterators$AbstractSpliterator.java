package org.teavm.classlib.java.util;
/** mc-web: java.util.Spliterators.AbstractSpliterator (MIT License). */
public abstract class TSpliterators$AbstractSpliterator<T> implements java.util.Spliterator<T> {
    private long est;
    private final int characteristics;
    protected TSpliterators$AbstractSpliterator(long est, int characteristics) { this.est = est; this.characteristics = characteristics; }
    @Override public java.util.Spliterator<T> trySplit() { return null; }
    @Override public long estimateSize() { return est; }
    @Override public int characteristics() { return characteristics; }
}
