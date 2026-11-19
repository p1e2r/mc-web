package org.lwjgl.web;

import org.lwjgl.system.CallbackI;
import org.lwjgl.system.MemoryUtil;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/** Entry points the JavaScript layer calls back into. Kept public and simple so CJ3Library can reach them. */
public final class WebBridge {
    private WebBridge() {}

    // ---- upcalls (C function pointers that call Java) ----
    private static final ConcurrentHashMap<Long, Object> UPCALLS = new ConcurrentHashMap<Long, Object>();
    private static final AtomicLong NEXT_UPCALL = new AtomicLong(0x10000000L);

    public static long upcallCreate(Object instance) {
        long id = NEXT_UPCALL.getAndAdd(16);
        UPCALLS.put(id, instance);
        return id;
    }

    @SuppressWarnings("unchecked")
    public static <T> T upcallGet(long id) {
        return (T)UPCALLS.get(id);
    }

    public static void upcallFree(long id) {
        UPCALLS.remove(id);
    }

    /** Invokes a callback with libffi-style arguments: {@code args} points to an array of pointers to argument values. */
    public static void invoke(double id, double ret, double args) {
        Object o = UPCALLS.get((long)id);
        if (o == null) {
            System.err.println("[lwjgl-web] invoke: unknown upcall " + Long.toHexString((long)id));
            return;
        }
        try {
            ((CallbackI)o).callback((long)ret, (long)args);
        } catch (Throwable t) {
            System.err.println("[lwjgl-web] exception in callback " + o);
            t.printStackTrace();
        }
    }

    // ---- global refs ----
    private static final ConcurrentHashMap<Long, Object> REFS = new ConcurrentHashMap<Long, Object>();
    private static final AtomicLong NEXT_REF = new AtomicLong(0x30000000L);

    public static long newGlobalRef(Object o) {
        if (o == null) {
            return 0L;
        }
        long id = NEXT_REF.getAndAdd(8);
        REFS.put(id, o);
        return id;
    }

    public static Object globalRef(double id) {
        return REFS.get((long)id);
    }

    public static void deleteGlobalRef(long id) {
        REFS.remove(id);
    }

    // ---- memory for the JS layer ----
    public static double malloc(double size) {
        return (double)MemoryUtil.nmemAlloc((long)size);
    }

    public static double calloc(double size) {
        return (double)MemoryUtil.nmemCalloc(1, (long)size);
    }

    public static void free(double ptr) {
        MemoryUtil.nmemFree((long)ptr);
    }
}
