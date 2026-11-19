package mcweb.rt.zip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/** mc-web: buffers everything, compresses on finish()/close() (MIT License). */
public class JsCompressOut extends OutputStream {
    private final int kind;
    protected OutputStream out;
    private ByteArrayOutputStream buf = new ByteArrayOutputStream(8192);

    JsCompressOut(int kind, OutputStream out) { this.kind = kind; this.out = out; }

    @Override public void write(int b) throws IOException { check(); buf.write(b); }
    @Override public void write(byte[] b, int off, int len) throws IOException { check(); buf.write(b, off, len); }
    @Override public void flush() throws IOException { }

    private void check() throws IOException { if (buf == null) throw new IOException("write beyond end of stream"); }

    public void finish() throws IOException {
        if (buf == null) return;
        byte[] data = buf.toByteArray();
        buf = null;
        out.write(JsZ.compress(kind, data, data.length));
        out.flush();
    }

    @Override public void close() throws IOException {
        if (out == null) return;
        try { finish(); } finally { out.close(); out = null; }
    }
}
