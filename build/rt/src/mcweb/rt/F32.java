package mcweb.rt;

import org.teavm.jso.JSBody;

/** mc-web: rounds a value to 32-bit float precision (TeaVM represents float as a JS double) (MIT License). */
public final class F32 {
    private F32() { }

    @JSBody(params = "x", script = "return Math.fround(x);")
    public static native float r(float x);
}
