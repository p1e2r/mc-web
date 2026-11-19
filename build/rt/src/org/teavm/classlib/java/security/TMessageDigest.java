package org.teavm.classlib.java.security;

import java.security.NoSuchAlgorithmException;

/** mc-web: MessageDigest with pure-Java MD5, SHA-1 and SHA-256 (MIT License). */
public abstract class TMessageDigest {
    private final String algorithm;
    private byte[] buf = new byte[64];
    private int bufLen;
    private long total;

    protected TMessageDigest(String algorithm) { this.algorithm = algorithm; }

    public static TMessageDigest getInstance(String algorithm) throws NoSuchAlgorithmException {
        switch (algorithm.toUpperCase()) {
            case "MD5": return new MD5();
            case "SHA-1": case "SHA1": case "SHA": return new SHA1();
            case "SHA-256": case "SHA256": return new SHA256();
            default: throw new NoSuchAlgorithmException(algorithm);
        }
    }
    public static TMessageDigest getInstance(String algorithm, String provider) throws NoSuchAlgorithmException { return getInstance(algorithm); }

    public final String getAlgorithm() { return algorithm; }
    public abstract int getDigestLength();
    public static boolean isEqual(byte[] a, byte[] b) { return java.util.Arrays.equals(a, b); }

    public void update(byte b) { buf[bufLen++] = b; total++; if (bufLen == 64) { block(buf, 0); bufLen = 0; } }
    public void update(byte[] in) { update(in, 0, in.length); }
    public void update(byte[] in, int off, int len) {
        for (int i = 0; i < len; i++) update(in[off + i]);
    }
    public final void update(java.nio.ByteBuffer input) { while (input.hasRemaining()) update(input.get()); }

    public byte[] digest(byte[] in) { update(in); return digest(); }
    public int digest(byte[] out, int off, int len) { byte[] d = digest(); System.arraycopy(d, 0, out, off, d.length); return d.length; }
    public byte[] digest() {
        long bits = total * 8;
        update((byte) 0x80);
        while (bufLen != 56) update((byte) 0);
        for (int i = 0; i < 8; i++) update((byte) (littleEndian() ? bits >>> (8 * i) : bits >>> (56 - 8 * i)));
        byte[] r = result();
        reset();
        return r;
    }
    public void reset() { bufLen = 0; total = 0; init(); }
    @Override public Object clone() throws CloneNotSupportedException { throw new CloneNotSupportedException(); }

    abstract void init();
    abstract void block(byte[] b, int off);
    abstract byte[] result();
    abstract boolean littleEndian();

    static final class MD5 extends TMessageDigest {
        private static final int[] S = {7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20,
            4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23, 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21};
        private static final int[] K = new int[64];
        static { for (int i = 0; i < 64; i++) K[i] = (int) (long) (Math.abs(Math.sin(i + 1)) * 4294967296.0); }
        int a, b, c, d;
        MD5() { super("MD5"); init(); }
        public int getDigestLength() { return 16; }
        boolean littleEndian() { return true; }
        void init() { a = 0x67452301; b = 0xefcdab89; c = 0x98badcfe; d = 0x10325476; }
        void block(byte[] x, int off) {
            int[] m = new int[16];
            for (int i = 0; i < 16; i++) m[i] = (x[off + 4 * i] & 0xff) | (x[off + 4 * i + 1] & 0xff) << 8 | (x[off + 4 * i + 2] & 0xff) << 16 | (x[off + 4 * i + 3] & 0xff) << 24;
            int A = a, B = b, C = c, D = d;
            for (int i = 0; i < 64; i++) {
                int f, g;
                if (i < 16) { f = (B & C) | (~B & D); g = i; }
                else if (i < 32) { f = (D & B) | (~D & C); g = (5 * i + 1) & 15; }
                else if (i < 48) { f = B ^ C ^ D; g = (3 * i + 5) & 15; }
                else { f = C ^ (B | ~D); g = (7 * i) & 15; }
                int t = D; D = C; C = B;
                B = B + Integer.rotateLeft(A + f + K[i] + m[g], S[i]);
                A = t;
            }
            a += A; b += B; c += C; d += D;
        }
        byte[] result() {
            byte[] r = new byte[16];
            int[] v = {a, b, c, d};
            for (int i = 0; i < 16; i++) r[i] = (byte) (v[i / 4] >>> (8 * (i % 4)));
            return r;
        }
    }

    static final class SHA1 extends TMessageDigest {
        int[] h = new int[5];
        SHA1() { super("SHA-1"); init(); }
        public int getDigestLength() { return 20; }
        boolean littleEndian() { return false; }
        void init() { h[0] = 0x67452301; h[1] = 0xEFCDAB89; h[2] = 0x98BADCFE; h[3] = 0x10325476; h[4] = 0xC3D2E1F0; }
        void block(byte[] x, int off) {
            int[] w = new int[80];
            for (int i = 0; i < 16; i++) w[i] = (x[off + 4 * i] & 0xff) << 24 | (x[off + 4 * i + 1] & 0xff) << 16 | (x[off + 4 * i + 2] & 0xff) << 8 | (x[off + 4 * i + 3] & 0xff);
            for (int i = 16; i < 80; i++) w[i] = Integer.rotateLeft(w[i - 3] ^ w[i - 8] ^ w[i - 14] ^ w[i - 16], 1);
            int a = h[0], b = h[1], c = h[2], d = h[3], e = h[4];
            for (int i = 0; i < 80; i++) {
                int f, k;
                if (i < 20) { f = (b & c) | (~b & d); k = 0x5A827999; }
                else if (i < 40) { f = b ^ c ^ d; k = 0x6ED9EBA1; }
                else if (i < 60) { f = (b & c) | (b & d) | (c & d); k = 0x8F1BBCDC; }
                else { f = b ^ c ^ d; k = 0xCA62C1D6; }
                int t = Integer.rotateLeft(a, 5) + f + e + k + w[i];
                e = d; d = c; c = Integer.rotateLeft(b, 30); b = a; a = t;
            }
            h[0] += a; h[1] += b; h[2] += c; h[3] += d; h[4] += e;
        }
        byte[] result() {
            byte[] r = new byte[20];
            for (int i = 0; i < 20; i++) r[i] = (byte) (h[i / 4] >>> (24 - 8 * (i % 4)));
            return r;
        }
    }

    static final class SHA256 extends TMessageDigest {
        private static final int[] K = {0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5,
            0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174, 0xe49b69c1, 0xefbe4786,
            0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da, 0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7,
            0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967, 0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb,
            0x81c2c92e, 0x92722c85, 0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
            0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3, 0x748f82ee, 0x78a5636f,
            0x84c87814, 0x8cc70208, 0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2};
        int[] h = new int[8];
        SHA256() { super("SHA-256"); init(); }
        public int getDigestLength() { return 32; }
        boolean littleEndian() { return false; }
        void init() { h = new int[]{0x6a09e667, 0xbb67ae85, 0x3c6ef372, 0xa54ff53a, 0x510e527f, 0x9b05688c, 0x1f83d9ab, 0x5be0cd19}; }
        void block(byte[] x, int off) {
            int[] w = new int[64];
            for (int i = 0; i < 16; i++) w[i] = (x[off + 4 * i] & 0xff) << 24 | (x[off + 4 * i + 1] & 0xff) << 16 | (x[off + 4 * i + 2] & 0xff) << 8 | (x[off + 4 * i + 3] & 0xff);
            for (int i = 16; i < 64; i++) {
                int s0 = Integer.rotateRight(w[i - 15], 7) ^ Integer.rotateRight(w[i - 15], 18) ^ (w[i - 15] >>> 3);
                int s1 = Integer.rotateRight(w[i - 2], 17) ^ Integer.rotateRight(w[i - 2], 19) ^ (w[i - 2] >>> 10);
                w[i] = w[i - 16] + s0 + w[i - 7] + s1;
            }
            int a = h[0], b = h[1], c = h[2], d = h[3], e = h[4], f = h[5], g = h[6], hh = h[7];
            for (int i = 0; i < 64; i++) {
                int S1 = Integer.rotateRight(e, 6) ^ Integer.rotateRight(e, 11) ^ Integer.rotateRight(e, 25);
                int ch = (e & f) ^ (~e & g);
                int t1 = hh + S1 + ch + K[i] + w[i];
                int S0 = Integer.rotateRight(a, 2) ^ Integer.rotateRight(a, 13) ^ Integer.rotateRight(a, 22);
                int t2 = S0 + ((a & b) ^ (a & c) ^ (b & c));
                hh = g; g = f; f = e; e = d + t1; d = c; c = b; b = a; a = t1 + t2;
            }
            h[0] += a; h[1] += b; h[2] += c; h[3] += d; h[4] += e; h[5] += f; h[6] += g; h[7] += hh;
        }
        byte[] result() {
            byte[] r = new byte[32];
            for (int i = 0; i < 32; i++) r[i] = (byte) (h[i / 4] >>> (24 - 8 * (i % 4)));
            return r;
        }
    }
}
