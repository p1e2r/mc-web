package mcweb.rt.zip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSByRef;

/** mc-web: gzip/zlib via fflate (TeaVM's jzlib-based streams fail on flush-after-finish) (MIT License). */
final class JsZ {
    static final int GZIP = 0, ZLIB = 1, RAW = 2;
    private JsZ() { }

    static byte[] compress(int kind, byte[] data, int len) {
        int n = ncompress(kind, data, len);
        byte[] out = new byte[n];
        take(out);
        return out;
    }

    static byte[] decompress(int kind, byte[] data, int len) throws IOException {
        int n = ndecompress(kind, data, len);
        if (n < 0) throw new java.util.zip.ZipException(err());
        byte[] out = new byte[n];
        take(out);
        return out;
    }

    static byte[] readAll(InputStream in) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream(8192);
        byte[] buf = new byte[8192];
        int r;
        while ((r = in.read(buf)) > 0) b.write(buf, 0, r);
        return b.toByteArray();
    }

    @JSBody(params = {"kind", "src", "len"}, script =
        "var s = new Uint8Array(src.buffer, src.byteOffset, len);"
        + "globalThis.__mcz = kind === 0 ? fflate.gzipSync(s) : kind === 1 ? fflate.zlibSync(s) : fflate.deflateSync(s);"
        + "return globalThis.__mcz.length;")
    private static native int ncompress(int kind, @JSByRef byte[] src, int len);

    @JSBody(params = {"kind", "src", "len"}, script =
        "var s = new Uint8Array(src.buffer, src.byteOffset, len);"
        + "try { globalThis.__mcz = kind === 0 ? fflate.gunzipSync(s) : kind === 1 ? fflate.unzlibSync(s) : fflate.inflateSync(s); }"
        + "catch (e) { globalThis.__mczErr = String(e && e.message || e); return -1; }"
        + "return globalThis.__mcz.length;")
    private static native int ndecompress(int kind, @JSByRef byte[] src, int len);

    @JSBody(params = "dst", script = "new Uint8Array(dst.buffer, dst.byteOffset, dst.length).set(globalThis.__mcz); globalThis.__mcz = null;")
    private static native void take(@JSByRef byte[] dst);

    @JSBody(script = "return globalThis.__mczErr || 'corrupt compressed data';")
    private static native String err();
}
