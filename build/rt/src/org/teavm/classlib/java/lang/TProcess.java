package org.teavm.classlib.java.lang;
/** mc-web: no processes in the browser (MIT License). */
public abstract class TProcess {
    public abstract java.io.OutputStream getOutputStream();
    public abstract java.io.InputStream getInputStream();
    public abstract java.io.InputStream getErrorStream();
    public abstract int waitFor() throws InterruptedException;
    public abstract int exitValue();
    public abstract void destroy();
}
