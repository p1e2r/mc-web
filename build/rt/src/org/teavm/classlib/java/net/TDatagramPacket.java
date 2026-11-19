package org.teavm.classlib.java.net;
/** mc-web (MIT License). */
public final class TDatagramPacket {
    private byte[] buf; private int off, len; private TInetAddress addr; private int port;
    public TDatagramPacket(byte[] b, int len) { this(b, 0, len); }
    public TDatagramPacket(byte[] b, int off, int len) { buf = b; this.off = off; this.len = len; }
    public TDatagramPacket(byte[] b, int len, TInetAddress a, int port) { this(b, 0, len); addr = a; this.port = port; }
    public TDatagramPacket(byte[] b, int off, int len, TInetAddress a, int port) { this(b, off, len); addr = a; this.port = port; }
    public TDatagramPacket(byte[] b, int len, TSocketAddress a) { this(b, 0, len); }
    public byte[] getData() { return buf; }
    public int getOffset() { return off; }
    public int getLength() { return len; }
    public TInetAddress getAddress() { return addr; }
    public int getPort() { return port; }
    public void setData(byte[] b) { buf = b; off = 0; len = b.length; }
}
