package org.teavm.classlib.java.security;
/** mc-web: no public-key crypto in the browser build (MIT License). */
public abstract class TKeyPairGenerator {
    public static TKeyPairGenerator getInstance(String alg) throws java.security.NoSuchAlgorithmException { throw new java.security.NoSuchAlgorithmException(alg); }
    public abstract void initialize(int keysize);
    public abstract TKeyPair generateKeyPair();
}
