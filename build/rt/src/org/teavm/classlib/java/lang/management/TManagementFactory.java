package org.teavm.classlib.java.lang.management;
/** mc-web: minimal management beans (MIT License). */
public class TManagementFactory {
    public static TMemoryMXBean getMemoryMXBean() { return new TMemoryMXBean() { }; }
    public static TThreadMXBean getThreadMXBean() { return new TThreadMXBean() { }; }
    public static java.util.List<TGarbageCollectorMXBean> getGarbageCollectorMXBeans() { return java.util.Collections.emptyList(); }
    public static TRuntimeMXBean getRuntimeMXBean() { return new TRuntimeMXBean() { }; }
}
