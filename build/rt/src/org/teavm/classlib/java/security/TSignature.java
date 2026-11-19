package org.teavm.classlib.java.security;
/** mc-web: no signatures in the browser build (MIT License). */
public abstract class TSignature {
    public static TSignature getInstance(String alg) throws java.security.NoSuchAlgorithmException { throw new java.security.NoSuchAlgorithmException(alg); }
    public abstract void initSign(TPrivateKey k) throws java.security.InvalidKeyException;
    public abstract void initVerify(TPublicKey k) throws java.security.InvalidKeyException;
    public abstract void update(byte[] b) throws java.security.SignatureException;
    public abstract void update(byte b) throws java.security.SignatureException;
    public abstract void update(byte[] b, int off, int len) throws java.security.SignatureException;
    public abstract byte[] sign() throws java.security.SignatureException;
    public abstract boolean verify(byte[] sig) throws java.security.SignatureException;
}
