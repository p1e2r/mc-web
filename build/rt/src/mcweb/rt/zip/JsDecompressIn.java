package mcweb.rt.zip;

import java.io.IOException;
import java.io.InputStream;

/** mc-web: reads the whole compressed stream on first use and decompresses it in one go (MIT License). */
public class JsDecompressIn extends InputStream {
    private final int kind;
    protected InputStream in;
    private byte[] data;
    private int pos;

    JsDecompressIn(int kind, InputStream in) { this.kind = kind; this.in = in; }

    private void fill() throws IOException {
        if (data != null) return;
        if (in == null) throw new IOException("Stream closed");
        byte[] raw = JsZ.readAll(in);
        data = JsZ.decompress(kind, raw, raw.length);
    }

    @Override public int read() throws IOException { fill(); return pos < data.length ? data[pos++] & 0xFF : -1; }

    @Override public int read(byte[] b, int off, int len) throws IOException {
        fill();
        if (len == 0) return 0;
        if (pos >= data.length) return -1;
        int n = Math.min(len, data.length - pos);
        System.arraycopy(data, pos, b, off, n);
        pos += n;
        return n;
    }

    @Override public long skip(long n) throws IOException {
        fill();
        int k = (int) Math.max(0, Math.min(n, data.length - pos));
        pos += k;
        return k;
    }

    @Override public int available() throws IOException { fill(); return data.length - pos; }
    @Override public void close() throws IOException { if (in != null) { in.close(); in = null; } }
}
