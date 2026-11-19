package org.teavm.classlib.java.net;
/** mc-web: no UDP in the browser (MIT License). */
public class TDatagramSocket implements java.io.Closeable {
    public TDatagramSocket() throws java.io.IOException { throw new java.io.IOException("UDP is not available in the browser"); }
    public TDatagramSocket(int port) throws java.io.IOException { this(); }
    public TDatagramSocket(TSocketAddress a) throws java.io.IOException { this(); }
    public void send(TDatagramPacket p) throws java.io.IOException { throw new java.io.IOException("no UDP"); }
    public void receive(TDatagramPacket p) throws java.io.IOException { throw new java.io.IOException("no UDP"); }
    public void setSoTimeout(int t) { }
    public void setBroadcast(boolean b) { }
    public int getLocalPort() { return -1; }
    public boolean isClosed() { return true; }
    public void close() { }
}
