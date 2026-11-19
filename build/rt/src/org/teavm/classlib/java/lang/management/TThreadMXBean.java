package org.teavm.classlib.java.lang.management;
/** mc-web (MIT License). */
public interface TThreadMXBean {
    default TThreadInfo[] dumpAllThreads(boolean a, boolean b) { return new TThreadInfo[0]; }
    default TThreadInfo[] dumpAllThreads(boolean a, boolean b, int depth) { return new TThreadInfo[0]; }
    default long[] getAllThreadIds() { return new long[0]; }
    default TThreadInfo getThreadInfo(long id) { return null; }
    default TThreadInfo[] getThreadInfo(long[] ids, int depth) { return new TThreadInfo[ids.length]; }
    default boolean isThreadCpuTimeSupported() { return false; }
    default long getThreadCpuTime(long id) { return -1; }
    default long getCurrentThreadCpuTime() { return -1; }
    default boolean isObjectMonitorUsageSupported() { return false; }
    default boolean isSynchronizerUsageSupported() { return false; }
    default int getThreadCount() { return 1; }
}
