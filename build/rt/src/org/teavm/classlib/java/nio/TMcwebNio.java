package org.teavm.classlib.java.nio;

import org.teavm.jso.JSBody;
import org.teavm.jso.typedarrays.ArrayBufferView;
import org.teavm.jso.typedarrays.Int8Array;

/** mc-web: direct buffers that are views of the native heap (LWJGLWeb.H.buf). MIT License. */
public final class TMcwebNio {
    private TMcwebNio() { }

    @JSBody(params = {"a", "n"}, script = "return new Int8Array(LWJGLWeb.H.buf, a, n);")
    private static native Int8Array view(int a, int n);

    @JSBody(params = "v", script = "return v.buffer === LWJGLWeb.H.buf;")
    private static native boolean onHeap(ArrayBufferView v);

    @JSBody(script = "return LWJGLWeb.H.buf.byteLength;")
    private static native int heapSize();

    public static TByteBuffer wrap(int address, int capacity) {
        // LWJGL wraps C strings of unknown length as Integer.MAX_VALUE-sized views; clamp to the end of the heap
        capacity = Math.max(0, Math.min(capacity, heapSize() - address));
        TByteBuffer b = new TByteBufferJsImpl(null, 0, view(address, capacity), true, false);
        b.limit(capacity);
        b.order(TByteOrder.LITTLE_ENDIAN);
        return b;
    }

    /** heap offset of element 0 of a direct buffer that lives on the native heap */
    public static long base(Object buffer) {
        if (buffer instanceof TArrayBufferViewProvider) {
            ArrayBufferView v = ((TArrayBufferViewProvider) buffer).getArrayBufferView();
            if (onHeap(v)) return v.getByteOffset();
        }
        throw new IllegalArgumentException("buffer is not on the native heap: " + buffer);
    }
}
