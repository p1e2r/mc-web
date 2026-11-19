package javax.crypto;
/** mc-web: no symmetric encryption in the browser build (singleplayer never encrypts). MIT License. */
public class Cipher {
    public static final int ENCRYPT_MODE = 1, DECRYPT_MODE = 2, WRAP_MODE = 3, UNWRAP_MODE = 4;
    protected Cipher() { }
    public static Cipher getInstance(String t) throws java.security.NoSuchAlgorithmException, NoSuchPaddingException { throw new java.security.NoSuchAlgorithmException(t); }
    public void init(int mode, java.security.Key key) throws java.security.InvalidKeyException { throw new UnsupportedOperationException(); }
    public void init(int mode, java.security.Key key, java.security.spec.AlgorithmParameterSpec p) throws java.security.InvalidKeyException { throw new UnsupportedOperationException(); }
    public byte[] doFinal(byte[] in) throws IllegalBlockSizeException, BadPaddingException { throw new UnsupportedOperationException(); }
    public byte[] update(byte[] in) { throw new UnsupportedOperationException(); }
    public int update(byte[] in, int off, int len, byte[] out, int outOff) throws ShortBufferException { throw new UnsupportedOperationException(); }
    public int update(byte[] in, int off, int len, byte[] out) throws ShortBufferException { throw new UnsupportedOperationException(); }
    public int getOutputSize(int len) { return len; }
}
