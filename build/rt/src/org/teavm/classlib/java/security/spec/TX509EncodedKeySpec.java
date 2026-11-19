package org.teavm.classlib.java.security.spec;
/** mc-web (MIT License). */
public class TX509EncodedKeySpec implements TKeySpec { private final byte[] k; public TX509EncodedKeySpec(byte[] k) { this.k = k.clone(); } public byte[] getEncoded() { return k.clone(); } }
