package mcweb.rt.zipfs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSByRef;

/** mc-web: read-only zip archive held in memory; entries are inflated on demand (MIT License). */
public final class ZipData {
    static final class Entry {
        final String name; final int method, localOffset; final long size, csize, time;
        Entry(String n, int m, int off, long size, long csize, long time) { name = n; method = m; localOffset = off; this.size = size; this.csize = csize; this.time = time; }
    }

    final byte[] data;
    final Map<String, Entry> files = new HashMap<>();          // "/a/b.json" -> entry
    final Map<String, TreeSet<String>> dirs = new HashMap<>(); // "/a" -> child names

    public ZipData(byte[] data) throws IOException {
        this.data = data;
        dirs.put("/", new TreeSet<>());
        int eocd = -1;
        for (int i = data.length - 22; i >= Math.max(0, data.length - 65557); i--)
            if (u32(i) == 0x06054b50L) { eocd = i; break; }
        if (eocd < 0) throw new IOException("not a zip file");
        int count = u16(eocd + 10);
        int p = (int) u32(eocd + 16);
        for (int k = 0; k < count; k++) {
            if (u32(p) != 0x02014b50L) throw new IOException("bad central directory");
            int method = u16(p + 10);
            long dosTime = u32(p + 12);
            long csize = u32(p + 20), size = u32(p + 24);
            int nlen = u16(p + 28), xlen = u16(p + 30), clen = u16(p + 32);
            int local = (int) u32(p + 42);
            String name = new String(data, p + 46, nlen, java.nio.charset.StandardCharsets.UTF_8);
            p += 46 + nlen + xlen + clen;
            String path = "/" + name;
            if (path.endsWith("/")) { addDir(path.substring(0, path.length() - 1)); continue; }
            files.put(path, new Entry(path, method, local, size, csize, dosToMillis(dosTime)));
            int slash = path.lastIndexOf('/');
            String parent = slash == 0 ? "/" : path.substring(0, slash);
            addDir(parent);
            dirs.get(parent).add(path.substring(slash + 1));
        }
    }

    private void addDir(String d) {
        if (d.isEmpty()) d = "/";
        if (dirs.containsKey(d)) return;
        dirs.put(d, new TreeSet<>());
        if (d.equals("/")) return;
        int slash = d.lastIndexOf('/');
        String parent = slash == 0 ? "/" : d.substring(0, slash);
        addDir(parent);
        dirs.get(parent).add(d.substring(slash + 1));
    }

    private int u16(int i) { return (data[i] & 0xff) | (data[i + 1] & 0xff) << 8; }
    private long u32(int i) { return (u16(i) | (long) u16(i + 2) << 16) & 0xFFFFFFFFL; }
    private static long dosToMillis(long t) {
        int date = (int) (t >>> 16), time = (int) (t & 0xffff);
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.clear();
        c.set(1980 + (date >> 9), ((date >> 5) & 15) - 1, Math.max(1, date & 31), time >> 11, (time >> 5) & 63, (time & 31) * 2);
        return c.getTimeInMillis();
    }

    public boolean isFile(String p) { return files.containsKey(p); }
    public boolean isDir(String p) { return dirs.containsKey(p); }
    public Set<String> list(String dir) { TreeSet<String> s = dirs.get(dir); return s == null ? Collections.emptySet() : s; }
    public long size(String p) { Entry e = files.get(p); return e == null ? 0 : e.size; }
    public long time(String p) { Entry e = files.get(p); return e == null ? 0 : e.time; }

    public InputStream open(String p) throws IOException {
        Entry e = files.get(p);
        if (e == null) throw new java.nio.file.NoSuchFileException(p);
        int lo = e.localOffset;
        int start = lo + 30 + u16(lo + 26) + u16(lo + 28);
        if (e.method == 0) return new ByteArrayInputStream(data, start, (int) e.csize);
        if (e.method == 8) {
            byte[] out = new byte[(int) e.size];
            inflate(data, start, (int) e.csize, out);
            return new ByteArrayInputStream(out);
        }
        throw new IOException("unsupported zip method " + e.method + " for " + p);
    }

    /** raw DEFLATE via fflate (TeaVM's InflaterInputStream fails on raw-deflate zip entries) */
    @JSBody(params = {"src", "off", "len", "dst"}, script =
        "fflate.inflateSync(new Uint8Array(src.buffer, src.byteOffset + off, len), { out: new Uint8Array(dst.buffer, dst.byteOffset, dst.length) });")
    private static native void inflate(@JSByRef byte[] src, int off, int len, @JSByRef byte[] dst);

    public byte[] read(String p) throws IOException {
        Entry e = files.get(p);
        if (e == null) throw new java.nio.file.NoSuchFileException(p);
        byte[] out = new byte[(int) e.size];
        try (InputStream in = open(p)) {
            int off = 0;
            while (off < out.length) { int n = in.read(out, off, out.length - off); if (n < 0) break; off += n; }
        }
        return out;
    }
}
