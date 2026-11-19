package org.teavm.classlib.java.net;
/** mc-web (MIT License). */
public final class TPasswordAuthentication {
    private final String user; private final char[] password;
    public TPasswordAuthentication(String user, char[] password) { this.user = user; this.password = password.clone(); }
    public String getUserName() { return user; }
    public char[] getPassword() { return password; }
}
