package org.lwjgl.web;

import java.util.HashMap;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSByRef;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/** Bridge from Java to the JavaScript "native" layer, TeaVM edition (MIT License). */
public final class WebFFI {
    private static final HashMap<String, Long> SYMBOLS = new HashMap<>();

    @JSFunctor
    public interface Upcall extends JSObject { void invoke(double id, double ret, double args); }

    static {
        setUpcall(WebBridge::invoke);
    }

    private WebFFI() { }

    @JSBody(params = "f", script = "LWJGLWeb.upcallFn = f;")
    private static native void setUpcall(Upcall f);

    /** Resolves a C symbol name to a fake function address understood by the JS layer. */
    public static long symbol(String name) {
        Long v = SYMBOLS.get(name);
        if (v == null) {
            v = (long) nsym(name);
            SYMBOLS.put(name, v);
        }
        return v;
    }

    @JSBody(params = "n", script = "return LWJGLWeb.symbol(n);")
    private static native double nsym(String name);

    /**
     * Calls a function previously returned by {@link #symbol}.
     * @param sig argument type chars, ':' and the return type char (B,S,C,I,J,F,D,Z,V)
     * @param args the arguments, all widened to double (pointers are below 2^53)
     */
    public static double call(long fn, String sig, double[] args) { return ncall((double) fn, sig, args); }

    @JSBody(params = {"fn", "sig", "args"}, script = "return LWJGLWeb.webffi.call(fn, sig, args) || 0;")
    private static native double ncall(double fn, String sig, @JSByRef double[] args);

    public static void init(String info) { }
}
