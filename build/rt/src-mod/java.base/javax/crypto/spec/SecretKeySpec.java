package javax.crypto.spec;
/** mc-web (MIT License). */
public class SecretKeySpec implements javax.crypto.SecretKey, java.security.spec.KeySpec {
    private final byte[] key; private final String alg;
    public SecretKeySpec(byte[] key, String alg) { this.key = key.clone(); this.alg = alg; }
    public String getAlgorithm() { return alg; }
    public String getFormat() { return "RAW"; }
    public byte[] getEncoded() { return key.clone(); }
}
