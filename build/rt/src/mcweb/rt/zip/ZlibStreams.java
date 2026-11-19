package mcweb.rt.zip;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/** mc-web: zlib stream factories for RegionFileVersion's DEFLATE chunk compression (MIT License). */
public final class ZlibStreams {
    private ZlibStreams() { }
    public static InputStream inflating(InputStream in) { return new JsDecompressIn(JsZ.ZLIB, in); }
    public static OutputStream deflating(OutputStream out) { return new BufferedOutputStream(new JsCompressOut(JsZ.ZLIB, out)); }
}
