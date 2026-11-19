package mcweb.rt.zip;

import java.io.InputStream;

/** mc-web: stands in for java.util.zip.GZIPInputStream (MIT License). */
public class GzipIn extends JsDecompressIn {
    public GzipIn(InputStream in) { super(JsZ.GZIP, in); }
    public GzipIn(InputStream in, int size) { super(JsZ.GZIP, in); }
}
