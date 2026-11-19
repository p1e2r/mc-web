package org.teavm.classlib.java.net;
/** mc-web: no sockets in the browser (MIT License). */
public class TSocket implements java.io.Closeable {
    public TSocket() { }
    public TSocket(String host, int port) throws java.io.IOException { throw new java.io.IOException("sockets are not available in the browser"); }
    public void connect(TSocketAddress a) throws java.io.IOException { throw new java.io.IOException("no sockets"); }
    public void connect(TSocketAddress a, int timeout) throws java.io.IOException { connect(a); }
    public java.io.InputStream getInputStream() throws java.io.IOException { throw new java.io.IOException("no sockets"); }
    public java.io.OutputStream getOutputStream() throws java.io.IOException { throw new java.io.IOException("no sockets"); }
    public void setSoTimeout(int t) { }
    public void setTcpNoDelay(boolean b) { }
    public boolean isConnected() { return false; }
    public boolean isClosed() { return true; }
    public int getPort() { return 0; }
    public void close() { }
}
