package org.teavm.classlib.java.util.zip;
/** mc-web: CRC-32C (Castagnoli) (MIT License). */
public final class TCRC32C implements java.util.zip.Checksum {
    private static final int[] T = new int[256];
    static { for (int i = 0; i < 256; i++) { int c = i; for (int k = 0; k < 8; k++) c = (c & 1) != 0 ? (c >>> 1) ^ 0x82F63B78 : c >>> 1; T[i] = c; } }
    private int crc = 0xFFFFFFFF;
    public void update(int b) { crc = (crc >>> 8) ^ T[(crc ^ b) & 0xff]; }
    public void update(byte[] b, int off, int len) { for (int i = 0; i < len; i++) update(b[off + i]); }
    public void update(java.nio.ByteBuffer b) { while (b.hasRemaining()) update(b.get()); }
    public long getValue() { return (~crc) & 0xFFFFFFFFL; }
    public void reset() { crc = 0xFFFFFFFF; }
}
