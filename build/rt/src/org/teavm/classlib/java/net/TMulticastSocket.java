package org.teavm.classlib.java.net;
/** mc-web: no multicast in the browser (MIT License). */
public class TMulticastSocket extends TDatagramSocket {
    public TMulticastSocket() throws java.io.IOException { super(); }
    public TMulticastSocket(int port) throws java.io.IOException { super(); }
    public void joinGroup(TInetAddress a) throws java.io.IOException { }
    public void leaveGroup(TInetAddress a) throws java.io.IOException { }
    public void joinGroup(TSocketAddress a, TNetworkInterface i) throws java.io.IOException { }
    public void leaveGroup(TSocketAddress a, TNetworkInterface i) throws java.io.IOException { }
    public void setTimeToLive(int ttl) { }
}
