package org.teavm.classlib.java.security.spec;
/** mc-web (MIT License). */
public class TPKCS8EncodedKeySpec implements TKeySpec { private final byte[] k; public TPKCS8EncodedKeySpec(byte[] k) { this.k = k.clone(); } public byte[] getEncoded() { return k.clone(); } }
