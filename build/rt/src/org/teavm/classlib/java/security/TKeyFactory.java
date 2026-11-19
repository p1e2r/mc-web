package org.teavm.classlib.java.security;
/** mc-web (MIT License). */
public abstract class TKeyFactory {
    public static TKeyFactory getInstance(String alg) throws java.security.NoSuchAlgorithmException { throw new java.security.NoSuchAlgorithmException(alg); }
    public abstract TPublicKey generatePublic(java.security.spec.KeySpec spec) throws java.security.spec.InvalidKeySpecException;
    public abstract TPrivateKey generatePrivate(java.security.spec.KeySpec spec) throws java.security.spec.InvalidKeySpecException;
}
