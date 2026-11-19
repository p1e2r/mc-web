package mcweb.rt;

import java.nio.*;
import org.teavm.jso.JSBody;

/**
 * mc-web native memory (MIT License). "Native" memory is one resizable JavaScript ArrayBuffer (LWJGLWeb.H, set up by
 * lw-heap.js); a pointer is a byte offset into it. Java direct buffers are typed-array views of the same buffer, so
 * Java, LWJGL and the WebGL layer all share memory without copying.
 */
public final class Mem {
    private Mem() { }

    // ---- raw access (little endian)
    @JSBody(params = "a", script = "return LWJGLWeb.H.dv.getInt8(a);") public static native byte getByte(int a);
    @JSBody(params = "a", script = "return LWJGLWeb.H.dv.getInt16(a, true);") public static native short getShort(int a);
    @JSBody(params = "a", script = "return LWJGLWeb.H.dv.getInt32(a, true);") public static native int getInt(int a);
    @JSBody(params = "a", script = "return LWJGLWeb.H.dv.getFloat32(a, true);") public static native float getFloat(int a);
    @JSBody(params = "a", script = "return LWJGLWeb.H.dv.getFloat64(a, true);") public static native double getDouble(int a);
    @JSBody(params = {"a", "v"}, script = "LWJGLWeb.H.dv.setInt8(a, v);") public static native void putByte(int a, byte v);
    @JSBody(params = {"a", "v"}, script = "LWJGLWeb.H.dv.setInt16(a, v, true);") public static native void putShort(int a, short v);
    @JSBody(params = {"a", "v"}, script = "LWJGLWeb.H.dv.setInt32(a, v, true);") public static native void putInt(int a, int v);
    @JSBody(params = {"a", "v"}, script = "LWJGLWeb.H.dv.setFloat32(a, v, true);") public static native void putFloat(int a, float v);
    @JSBody(params = {"a", "v"}, script = "LWJGLWeb.H.dv.setFloat64(a, v, true);") public static native void putDouble(int a, double v);
    public static long getLong(int a) { return (getInt(a) & 0xFFFFFFFFL) | ((long) getInt(a + 4) << 32); }
    public static void putLong(int a, long v) { putInt(a, (int) v); putInt(a + 4, (int) (v >>> 32)); }

    @JSBody(params = {"d", "s", "n"}, script = "LWJGLWeb.H.u8.copyWithin(d, s, s + n);") public static native void copy(int dst, int src, int n);
    @JSBody(params = {"d", "v", "n"}, script = "LWJGLWeb.H.u8.fill(v & 255, d, d + n);") public static native void set(int dst, int v, int n);

    // ---- allocator (lw-heap.js)
    @JSBody(params = "n", script = "return LWJGLWeb.heap.malloc(n);") public static native int malloc(int n);
    @JSBody(params = {"n", "s"}, script = "return LWJGLWeb.heap.calloc(n, s);") public static native int calloc(int n, int s);
    @JSBody(params = {"p", "n"}, script = "return LWJGLWeb.heap.realloc(p, n);") public static native int realloc(int p, int n);
    @JSBody(params = "p", script = "LWJGLWeb.heap.free(p);") public static native void free(int p);
    @JSBody(params = {"al", "n"}, script = "return LWJGLWeb.heap.aligned(al, n);") public static native int aligned(int alignment, int n);

    static int ptr(long p) {
        if (p < 0 || p > 0x7FFFFFFFL) throw new IllegalArgumentException("bad pointer " + p);
        return (int) p;
    }

    // ---- LWJGL MemoryUtil replacements (patched in by body rules)
    public static long nmemAlloc(long size) { return malloc((int) Math.max(1, size)); }
    public static long nmemCalloc(long num, long size) { return calloc((int) num, (int) size); }
    public static long nmemRealloc(long p, long size) { return realloc(ptr(p), (int) size); }
    public static void nmemFree(long p) { if (p != 0) free(ptr(p)); }
    public static long nmemAlignedAlloc(long alignment, long size) { return aligned((int) alignment, (int) size); }
    public static void nmemAlignedFree(long p) { if (p != 0) free(ptr(p)); }

    public static ByteBuffer allocateDirect(int cap) {
        int p = calloc(Math.max(1, cap), 1);
        // like the JDK: direct buffers start big-endian (LWJGL sets native order itself; Netty relies on this)
        return (ByteBuffer) wrapBufferByte(p, cap).order(java.nio.ByteOrder.BIG_ENDIAN);
    }

    public static ByteBuffer wrapBufferByte(long address, int cap) { return (ByteBuffer) (Object) org.teavm.classlib.java.nio.TMcwebNio.wrap(ptr(address), cap); }
    public static ShortBuffer wrapBufferShort(long a, int cap) { return wrapBufferByte(a, cap * 2).asShortBuffer(); }
    public static CharBuffer wrapBufferChar(long a, int cap) { return wrapBufferByte(a, cap * 2).asCharBuffer(); }
    public static IntBuffer wrapBufferInt(long a, int cap) { return wrapBufferByte(a, cap * 4).asIntBuffer(); }
    public static LongBuffer wrapBufferLong(long a, int cap) { return wrapBufferByte(a, cap * 8).asLongBuffer(); }
    public static FloatBuffer wrapBufferFloat(long a, int cap) { return wrapBufferByte(a, cap * 4).asFloatBuffer(); }
    public static DoubleBuffer wrapBufferDouble(long a, int cap) { return wrapBufferByte(a, cap * 8).asDoubleBuffer(); }

    /** address of element 0 of the buffer (not of its position): LWJGL's memAddress0 */
    public static long memAddress0(Buffer b) { return org.teavm.classlib.java.nio.TMcwebNio.base(b); }
    public static long memAddress0(ByteBuffer b) { return memAddress0((Buffer) b); }
    public static long memAddress0(ShortBuffer b) { return memAddress0((Buffer) b); }
    public static long memAddress0(CharBuffer b) { return memAddress0((Buffer) b); }
    public static long memAddress0(IntBuffer b) { return memAddress0((Buffer) b); }
    public static long memAddress0(LongBuffer b) { return memAddress0((Buffer) b); }
    public static long memAddress0(FloatBuffer b) { return memAddress0((Buffer) b); }
    public static long memAddress0(DoubleBuffer b) { return memAddress0((Buffer) b); }

    public static ByteBuffer slice(ByteBuffer src, long address, int cap) { return wrapBufferByte(address, cap); }
    public static ByteBuffer memSlice(ByteBuffer b) { return wrapBufferByte(memAddress0(b) + b.position(), b.remaining()); }
    public static ByteBuffer memSlice(ByteBuffer b, int offset, int cap) { return wrapBufferByte(memAddress0(b) + b.position() + offset, cap); }
    public static ByteBuffer memDuplicate(ByteBuffer b) {
        ByteBuffer d = wrapBufferByte(memAddress0(b), b.capacity());
        d.limit(b.limit()); d.position(b.position());
        return d;
    }
    @SuppressWarnings("unchecked")
    public static <T extends Buffer> T realloc(T oldBuf, T newBuf, int size) {
        if (oldBuf != null) {
            newBuf.position(Math.min(oldBuf.position(), size));
        }
        return newBuf;
    }
    public static long offsetAddress() { return FakeUnsafe.BUF_ADDRESS; }
    public static long offsetMark() { return FakeUnsafe.BUF_MARK; }
    public static long offsetPosition() { return FakeUnsafe.BUF_POSITION; }
    public static long offsetLimit() { return FakeUnsafe.BUF_LIMIT; }
    public static long offsetCapacity() { return FakeUnsafe.BUF_CAPACITY; }
    public static FakeUnsafe unsafe() { return FakeUnsafe.INSTANCE; }
}
