package org.teavm.classlib.java.security;
/** mc-web (MIT License). */
public final class TKeyPair implements java.io.Serializable {
    private final TPublicKey pub; private final TPrivateKey priv;
    public TKeyPair(TPublicKey pub, TPrivateKey priv) { this.pub = pub; this.priv = priv; }
    public TPublicKey getPublic() { return pub; }
    public TPrivateKey getPrivate() { return priv; }
}
