package org.lwjgl.system;

import org.lwjgl.web.WebBridge;

/** lwjgl-web: callbacks are kept in a Java-side table; JS invokes them through WebBridge.invoke. */
final class Upcalls {
    private Upcalls() {}

    static long upcallCreate(Callback.Descriptor descriptor, Object instance) {
        return WebBridge.upcallCreate(instance);
    }

    static <T extends CallbackI> T upcallGet(long functionPointer) {
        return WebBridge.<T>upcallGet(functionPointer);
    }

    static void upcallFree(long functionPointer) {
        WebBridge.upcallFree(functionPointer);
    }
}
