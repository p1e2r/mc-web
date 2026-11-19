package org.teavm.classlib.java.net;
/** mc-web: no listening sockets in the browser (MIT License). */
public class TServerSocket implements java.io.Closeable {
    public TServerSocket() throws java.io.IOException { throw new java.io.IOException("sockets are not available in the browser"); }
    public TServerSocket(int port) throws java.io.IOException { this(); }
    public TServerSocket(int port, int backlog) throws java.io.IOException { this(); }
    public TServerSocket(int port, int backlog, TInetAddress a) throws java.io.IOException { this(); }
    public int getLocalPort() { return -1; }
    public void setReuseAddress(boolean b) { }
    public void bind(TSocketAddress a) throws java.io.IOException { }
    public TSocket accept() throws java.io.IOException { throw new java.io.IOException("no sockets"); }
    public boolean isClosed() { return true; }
    public void close() { }
}
