package org.teavm.classlib.java.net;
/** mc-web: no DNS in the browser (MIT License). */
public class TInetAddress implements java.io.Serializable {
    private final String host;
    private final byte[] bytes;
    TInetAddress(String host) { this(host, null); }
    TInetAddress(String host, byte[] bytes) { this.host = host; this.bytes = bytes; }
    public static TInetAddress getByName(String host) throws java.net.UnknownHostException {
        if (host == null || host.isEmpty() || host.equals("localhost")) return getLoopbackAddress();
        String[] p = host.split("\\.");
        if (p.length == 4) {
            try { byte[] b = new byte[4]; for (int i = 0; i < 4; i++) { int v = Integer.parseInt(p[i]); if (v < 0 || v > 255) throw new NumberFormatException(); b[i] = (byte) v; } return new TInet4Address(host, b); }
            catch (NumberFormatException e) { }
        }
        return new TInetAddress(host);
    }
    public static TInetAddress[] getAllByName(String host) throws java.net.UnknownHostException { return new TInetAddress[]{getByName(host)}; }
    public static TInetAddress getByAddress(byte[] b) throws java.net.UnknownHostException { return getByAddress(null, b); }
    public static TInetAddress getByAddress(String host, byte[] b) throws java.net.UnknownHostException {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < b.length; i++) { if (i > 0) s.append('.'); s.append(b[i] & 0xff); }
        return b.length == 16 ? new TInet6Address(host != null ? host : s.toString(), b) : b.length == 4 ? new TInet4Address(host != null ? host : s.toString(), b) : new TInetAddress(host != null ? host : s.toString(), b);
    }
    public static TInetAddress getLocalHost() { return new TInet4Address("localhost", new byte[]{127, 0, 0, 1}); }
    public static TInetAddress getLoopbackAddress() { return new TInet4Address("127.0.0.1", new byte[]{127, 0, 0, 1}); }
    public String getHostAddress() { return host; }
    public String getHostName() { return host; }
    public String getCanonicalHostName() { return host; }
    public byte[] getAddress() { return bytes != null ? bytes.clone() : new byte[]{127, 0, 0, 1}; }
    public boolean isLoopbackAddress() { return "127.0.0.1".equals(host) || "localhost".equals(host); }
    public boolean isAnyLocalAddress() { return "0.0.0.0".equals(host); }
    public boolean isSiteLocalAddress() { return false; }
    public boolean isLinkLocalAddress() { return false; }
    public boolean isMulticastAddress() { return false; }
    @Override public String toString() { return host; }
    @Override public boolean equals(Object o) { return o instanceof TInetAddress && java.util.Objects.equals(((TInetAddress) o).host, host); }
    @Override public int hashCode() { return java.util.Objects.hashCode(host); }
}
