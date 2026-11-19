package org.teavm.classlib.java.net;
/** mc-web (MIT License). */
public abstract class TAuthenticator {
    public static void setDefault(TAuthenticator a) { }
    protected TPasswordAuthentication getPasswordAuthentication() { return null; }
}
