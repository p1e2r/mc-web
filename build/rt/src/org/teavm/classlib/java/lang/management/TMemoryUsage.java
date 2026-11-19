package org.teavm.classlib.java.lang.management;
/** mc-web (MIT License). */
public class TMemoryUsage {
    static final long START = System.currentTimeMillis();
    private final long init, used, committed, max;
    public TMemoryUsage(long init, long used, long committed, long max) { this.init = init; this.used = used; this.committed = committed; this.max = max; }
    public long getInit() { return init; }
    public long getUsed() { return used; }
    public long getCommitted() { return committed; }
    public long getMax() { return max; }
}
