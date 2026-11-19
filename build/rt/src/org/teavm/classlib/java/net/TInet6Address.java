package org.teavm.classlib.java.net;
/** mc-web (MIT License). */
public final class TInet6Address extends TInetAddress { TInet6Address(String h, byte[] b) { super(h, b); } public int getScopeId() { return 0; }
    public static TInet6Address getByAddress(String h, byte[] b, int scope) { return new TInet6Address(h, b); }
    public static TInet6Address getByAddress(String h, byte[] b, TNetworkInterface nif) { return new TInet6Address(h, b); }
    public TNetworkInterface getScopedInterface() { return null; } }
