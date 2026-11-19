package javax.crypto;
/** mc-web (MIT License). */
public class KeyGenerator {
    protected KeyGenerator() { }
    public static KeyGenerator getInstance(String a) throws java.security.NoSuchAlgorithmException { throw new java.security.NoSuchAlgorithmException(a); }
    public void init(int size) { }
    public SecretKey generateKey() { throw new UnsupportedOperationException(); }
}
