package org.lwjgl.web;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSByRef;

/**
 * mc-web: GLFW event delivery from Java (MIT License). Callbacks run here rather than inside the JS
 * glfwPollEvents call, so game code they trigger (e.g. a screen that blocks on a future) may suspend.
 */
public final class WebEvents {
    private WebEvents() { }

    public static void pollEvents() {
        pollDeferred();
        double[] u = new double[3];
        while (take(u)) {
            try {
                WebBridge.invoke(u[0], u[1], u[2]);
            } finally {
                free(u[1]);
            }
        }
    }

    @JSBody(script = "LWJGLWeb.glfwPollDeferred();")
    private static native void pollDeferred();

    @JSBody(params = "out", script = "return LWJGLWeb.takeUpcall(out);")
    private static native boolean take(@JSByRef double[] out);

    @JSBody(params = "p", script = "LWJGLWeb.free(p);")
    private static native void free(double p);
}
