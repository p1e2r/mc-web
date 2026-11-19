package mcweb.rt.zip;

import java.io.OutputStream;

/** mc-web: stands in for java.util.zip.GZIPOutputStream (MIT License). */
public class GzipOut extends JsCompressOut {
    public GzipOut(OutputStream out) { super(JsZ.GZIP, out); }
    public GzipOut(OutputStream out, int size) { super(JsZ.GZIP, out); }
    public GzipOut(OutputStream out, boolean syncFlush) { super(JsZ.GZIP, out); }
    public GzipOut(OutputStream out, int size, boolean syncFlush) { super(JsZ.GZIP, out); }
}
