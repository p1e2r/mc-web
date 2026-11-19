package org.teavm.classlib.java.net;
/** mc-web: java.net.Proxy (no proxies in the browser). MIT License. */
public class TProxy {
    public enum Type { DIRECT, HTTP, SOCKS }
    public static final TProxy NO_PROXY = new TProxy();
    private final Type type;
    private final java.net.SocketAddress sa;
    private TProxy() { type = Type.DIRECT; sa = null; }
    public TProxy(Type type, java.net.SocketAddress sa) { this.type = type; this.sa = sa; }
    public Type type() { return type; }
    public java.net.SocketAddress address() { return sa; }
    @Override public String toString() { return type == Type.DIRECT ? "DIRECT" : type + " @ " + sa; }
}
