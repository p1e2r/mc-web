package org.teavm.classlib.java.lang.management;
/** mc-web (MIT License). */
public interface TMemoryMXBean {
    default TMemoryUsage getHeapMemoryUsage() { return new TMemoryUsage(0, 0, 0, 2048L << 20); }
    default TMemoryUsage getNonHeapMemoryUsage() { return new TMemoryUsage(0, 0, 0, -1); }
}
