package org.lwjgl.system;

import org.lwjgl.PointerBuffer;

/** lwjgl-web: the HotSpot JNIEnv tricks are not needed; the JS GL layer ignores function pointers. */
public final class ThreadLocalUtil {
    private ThreadLocalUtil() {}

    public static void setCapabilities(long capabilities) {}

    public static void setFunctionMissingAddresses(int functionCount) {}

    public static PointerBuffer setupAddressBuffer(PointerBuffer addresses) {
        return addresses;
    }

    public static boolean areCapabilitiesDifferent(PointerBuffer ref, PointerBuffer caps) {
        for (int i = 0; i < ref.remaining(); i++) {
            if (ref.get(i) != caps.get(i) && caps.get(i) != 0L) {
                return true;
            }
        }
        return false;
    }
}
