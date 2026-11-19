package org.teavm.classlib.java.lang.management;
/** mc-web (MIT License). */
public interface TRuntimeMXBean {
    default java.util.List<String> getInputArguments() { return java.util.Collections.emptyList(); }
    default long getUptime() { return System.currentTimeMillis() - TMemoryUsage.START; }
    default long getStartTime() { return TMemoryUsage.START; }
}
