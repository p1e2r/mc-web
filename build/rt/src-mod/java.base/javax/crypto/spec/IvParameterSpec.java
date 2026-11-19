package javax.crypto.spec;
/** mc-web (MIT License). */
public class IvParameterSpec implements java.security.spec.AlgorithmParameterSpec { private final byte[] iv; public IvParameterSpec(byte[] iv) { this.iv = iv.clone(); } public byte[] getIV() { return iv.clone(); } }
