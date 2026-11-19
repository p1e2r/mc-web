package mcweb.rt;

import org.teavm.interop.Async;
import org.teavm.interop.AsyncCallback;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/** mc-web: end of frame. Returning to the browser's event loop is what presents the WebGL frame. MIT License. */
public final class Frame {
    private Frame() { }

    @JSFunctor
    interface Done extends JSObject { void done(); }

    @JSBody(params = "w", script = "LWJGLWeb.endFrame(w);")
    private static native void endFrame(double window);

    @JSBody(params = "f", script = "requestAnimationFrame(function () { f(); });")
    private static native void raf(Done f);

    public static void swap(long window) {
        endFrame((double) window);
        waitFrame();
    }

    @Async
    private static native void waitFrame();

    private static void waitFrame(AsyncCallback<Void> cb) { raf(() -> cb.complete(null)); }

    /** Yield to the browser (lets events, timers and fetches run) without waiting for a frame. */
    @Async
    public static native void yieldNow();

    private static void yieldNow(AsyncCallback<Void> cb) { setTimeout0(() -> cb.complete(null)); }

    @JSBody(params = "f", script = "setTimeout(function () { f(); }, 0);")
    private static native void setTimeout0(Done f);

    private static double lastYield;

    /**
     * Called by the worker pools between tasks: once the current green thread has run for a few milliseconds,
     * yield so the browser can render a frame. Without this, chunk meshing/generation runs back to back on the one
     * JS thread and causes frame spikes.
     */
    public static void maybeYield() {
        double now = now();
        if (now - lastYield < 8) return;
        yieldNow();
        lastYield = now();
    }

    @JSBody(script = "return performance.now();")
    private static native double now();
}
