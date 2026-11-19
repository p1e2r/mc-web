package org.teavm.classlib.java.lang.management;
/** mc-web (MIT License). */
public class TThreadInfo {
    public String getThreadName() { return ""; }
    public long getThreadId() { return 0; }
    public Thread.State getThreadState() { return Thread.State.RUNNABLE; }
    public StackTraceElement[] getStackTrace() { return new StackTraceElement[0]; }
    public boolean isDaemon() { return false; }
    public String getLockName() { return null; }
}
