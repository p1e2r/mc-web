package org.teavm.classlib.java.net;
/** mc-web: no interfaces visible from the browser (MIT License). */
public final class TNetworkInterface {
    public static java.util.Enumeration<TNetworkInterface> getNetworkInterfaces() { return java.util.Collections.emptyEnumeration(); }
    public static TNetworkInterface getByName(String n) { return null; }
    public static TNetworkInterface getByInetAddress(TInetAddress a) { return null; }
    public static TNetworkInterface getByIndex(int i) { return null; }
    public String getName() { return "lo"; }
    public String getDisplayName() { return "lo"; }
    public int getIndex() { return 0; }
    public boolean isUp() { return false; }
    public boolean isLoopback() { return true; }
    public boolean isVirtual() { return false; }
    public boolean supportsMulticast() { return false; }
    public byte[] getHardwareAddress() { return null; }
    public java.util.Enumeration<TInetAddress> getInetAddresses() { return java.util.Collections.emptyEnumeration(); }
}
