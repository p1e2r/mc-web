package org.teavm.classlib.java.net;
/** mc-web: address holder only; no sockets in the browser (MIT License). */
public class TInetSocketAddress extends TSocketAddress {
    private final String host; private final TInetAddress addr; private final int port;
    public TInetSocketAddress(int port) { this((String) null, port); }
    public TInetSocketAddress(String host, int port) { this.host = host; this.addr = host == null ? null : new TInetAddress(host); this.port = port; }
    public TInetSocketAddress(TInetAddress addr, int port) { this.addr = addr; this.host = addr == null ? null : addr.getHostAddress(); this.port = port; }
    public static TInetSocketAddress createUnresolved(String host, int port) { return new TInetSocketAddress(host, port); }
    public final int getPort() { return port; }
    public final TInetAddress getAddress() { return addr; }
    public final String getHostName() { return host; }
    public final String getHostString() { return host; }
    public final boolean isUnresolved() { return false; }
    @Override public String toString() { return host + ":" + port; }
    @Override public boolean equals(Object o) { return o instanceof TInetSocketAddress && java.util.Objects.equals(((TInetSocketAddress) o).host, host) && ((TInetSocketAddress) o).port == port; }
    @Override public int hashCode() { return java.util.Objects.hashCode(host) * 31 + port; }
}
