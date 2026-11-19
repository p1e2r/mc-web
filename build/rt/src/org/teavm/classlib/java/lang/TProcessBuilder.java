package org.teavm.classlib.java.lang;
/** mc-web: no processes in the browser (MIT License). */
public final class TProcessBuilder {
    public TProcessBuilder(String... cmd) { }
    public TProcessBuilder(java.util.List<String> cmd) { }
    public TProcessBuilder redirectErrorStream(boolean b) { return this; }
    public TProcess start() throws java.io.IOException { throw new java.io.IOException("processes are not available in the browser"); }
}
