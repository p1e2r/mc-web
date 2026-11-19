package mcweb.rt;

import java.security.MessageDigest;

/** mc-web: full java.util.UUID (MIT License). */
public final class UUID implements java.io.Serializable, Comparable<UUID> {
    private final long msb, lsb;

    public UUID(long mostSigBits, long leastSigBits) { msb = mostSigBits; lsb = leastSigBits; }

    public static UUID randomUUID() {
        java.util.Random r = new java.util.Random();
        long m = r.nextLong(), l = r.nextLong();
        m = (m & ~0xF000L) | 0x4000L;
        l = (l & 0x3FFFFFFFFFFFFFFFL) | 0x8000000000000000L;
        return new UUID(m, l);
    }

    public static UUID nameUUIDFromBytes(byte[] name) {
        byte[] md5;
        try { md5 = MessageDigest.getInstance("MD5").digest(name); } catch (Exception e) { throw new InternalError(e); }
        md5[6] &= 0x0f; md5[6] |= 0x30;
        md5[8] &= 0x3f; md5[8] |= (byte) 0x80;
        long m = 0, l = 0;
        for (int i = 0; i < 8; i++) m = (m << 8) | (md5[i] & 0xff);
        for (int i = 8; i < 16; i++) l = (l << 8) | (md5[i] & 0xff);
        return new UUID(m, l);
    }

    public static UUID fromString(String name) {
        String[] c = name.split("-");
        if (c.length != 5) throw new IllegalArgumentException("Invalid UUID string: " + name);
        long m = Long.parseLong(c[0], 16);
        m <<= 16; m |= Long.parseLong(c[1], 16);
        m <<= 16; m |= Long.parseLong(c[2], 16);
        long l = Long.parseLong(c[3], 16);
        l <<= 48; l |= Long.parseLong(c[4], 16);
        return new UUID(m, l);
    }

    public long getLeastSignificantBits() { return lsb; }
    public long getMostSignificantBits() { return msb; }
    public int version() { return (int) ((msb >> 12) & 0x0f); }
    public int variant() { return (int) ((lsb >>> (64 - (lsb >>> 62))) & (lsb >> 63)); }

    private static String hex(long v, int digits) {
        long hi = 1L << (digits * 4);
        return Long.toHexString(hi | (v & (hi - 1))).substring(1);
    }

    @Override public String toString() {
        return hex(msb >> 32, 8) + "-" + hex(msb >> 16, 4) + "-" + hex(msb, 4) + "-" + hex(lsb >> 48, 4) + "-" + hex(lsb, 12);
    }
    @Override public int hashCode() { long h = msb ^ lsb; return ((int) (h >> 32)) ^ (int) h; }
    @Override public boolean equals(Object o) {
        if (!(o instanceof UUID)) return false;
        UUID u = (UUID) o;
        return msb == u.msb && lsb == u.lsb;
    }
    @Override public int compareTo(UUID v) {
        int c = Long.compare(msb, v.msb);
        return c != 0 ? c : Long.compare(lsb, v.lsb);
    }
}
