package mcweb.rt;

/**
 * mc-web: sun.misc.Unsafe replacement (MIT License). The patcher renames sun/misc/Unsafe to this class everywhere.
 * A null base means "native address" (see Mem); an array base means array element access with base offset 0.
 * Field-offset tricks are not supported (callers fall back or were patched).
 */
public final class FakeUnsafe {
    public static final FakeUnsafe INSTANCE = new FakeUnsafe();
    public static final FakeUnsafe theUnsafe = INSTANCE;
    public static final int INVALID_FIELD_OFFSET = -1;
    public static final int ARRAY_BOOLEAN_BASE_OFFSET = 0, ARRAY_BYTE_BASE_OFFSET = 0, ARRAY_SHORT_BASE_OFFSET = 0, ARRAY_CHAR_BASE_OFFSET = 0,
        ARRAY_INT_BASE_OFFSET = 0, ARRAY_LONG_BASE_OFFSET = 0, ARRAY_FLOAT_BASE_OFFSET = 0, ARRAY_DOUBLE_BASE_OFFSET = 0, ARRAY_OBJECT_BASE_OFFSET = 0;
    public static final int ARRAY_BOOLEAN_INDEX_SCALE = 1, ARRAY_BYTE_INDEX_SCALE = 1, ARRAY_SHORT_INDEX_SCALE = 2, ARRAY_CHAR_INDEX_SCALE = 2,
        ARRAY_INT_INDEX_SCALE = 4, ARRAY_LONG_INDEX_SCALE = 8, ARRAY_FLOAT_INDEX_SCALE = 4, ARRAY_DOUBLE_INDEX_SCALE = 8, ARRAY_OBJECT_INDEX_SCALE = 4;
    public static final int ADDRESS_SIZE = 8;

    public static FakeUnsafe getUnsafe() { return INSTANCE; }

    // Fake field offsets that LWJGL's MemoryUtil uses on java.nio.Buffer objects (see Mem.offset*).
    public static final long BUF_ADDRESS = 0x1001, BUF_MARK = 0x1002, BUF_POSITION = 0x1003, BUF_LIMIT = 0x1004, BUF_CAPACITY = 0x1005;

    private static int bufferInt(java.nio.Buffer b, long off) {
        if (off == BUF_POSITION) return b.position();
        if (off == BUF_LIMIT) return b.limit();
        if (off == BUF_CAPACITY) return b.capacity();
        if (off == BUF_MARK) return -1;
        throw unsupported(b);
    }
    private static void bufferPutInt(java.nio.Buffer b, long off, int v) {
        if (off == BUF_POSITION) { b.position(v); return; }
        if (off == BUF_LIMIT) { b.limit(v); return; }
        if (off == BUF_MARK) return;
        throw unsupported(b);
    }

    private static UnsupportedOperationException unsupported(Object base) {
        return new UnsupportedOperationException("Unsafe field access on " + (base == null ? "null" : base.getClass().getName()));
    }

    // ---- bytes / numbers with base
    public byte getByte(Object o, long off) {
        if (o == null) return Mem.getByte(Mem.ptr(off));
        if (o instanceof byte[]) return ((byte[]) o)[(int) off];
        if (o instanceof boolean[]) return (byte) (((boolean[]) o)[(int) off] ? 1 : 0);
        throw unsupported(o);
    }
    public void putByte(Object o, long off, byte v) {
        if (o == null) { Mem.putByte(Mem.ptr(off), v); return; }
        if (o instanceof byte[]) { ((byte[]) o)[(int) off] = v; return; }
        if (o instanceof boolean[]) { ((boolean[]) o)[(int) off] = v != 0; return; }
        throw unsupported(o);
    }
    public boolean getBoolean(Object o, long off) { return getByte(o, off) != 0; }
    public void putBoolean(Object o, long off, boolean v) { putByte(o, off, (byte) (v ? 1 : 0)); }
    public short getShort(Object o, long off) {
        if (o == null) return Mem.getShort(Mem.ptr(off));
        if (o instanceof short[]) return ((short[]) o)[(int) (off >> 1)];
        if (o instanceof byte[]) { byte[] b = (byte[]) o; int i = (int) off; return (short) ((b[i] & 0xff) | b[i + 1] << 8); }
        throw unsupported(o);
    }
    public void putShort(Object o, long off, short v) {
        if (o == null) { Mem.putShort(Mem.ptr(off), v); return; }
        if (o instanceof short[]) { ((short[]) o)[(int) (off >> 1)] = v; return; }
        if (o instanceof byte[]) { byte[] b = (byte[]) o; int i = (int) off; b[i] = (byte) v; b[i + 1] = (byte) (v >> 8); return; }
        throw unsupported(o);
    }
    public char getChar(Object o, long off) {
        if (o instanceof char[]) return ((char[]) o)[(int) (off >> 1)];
        return (char) getShort(o, off);
    }
    public void putChar(Object o, long off, char v) {
        if (o instanceof char[]) { ((char[]) o)[(int) (off >> 1)] = v; return; }
        putShort(o, off, (short) v);
    }
    public int getInt(Object o, long off) {
        if (o == null) return Mem.getInt(Mem.ptr(off));
        if (o instanceof java.nio.Buffer) return bufferInt((java.nio.Buffer) o, off);
        if (o instanceof int[]) return ((int[]) o)[(int) (off >> 2)];
        if (o instanceof byte[]) { byte[] b = (byte[]) o; int i = (int) off; return (b[i] & 0xff) | (b[i + 1] & 0xff) << 8 | (b[i + 2] & 0xff) << 16 | b[i + 3] << 24; }
        if (o instanceof float[]) return Float.floatToRawIntBits(((float[]) o)[(int) (off >> 2)]);
        throw unsupported(o);
    }
    public void putInt(Object o, long off, int v) {
        if (o == null) { Mem.putInt(Mem.ptr(off), v); return; }
        if (o instanceof java.nio.Buffer) { bufferPutInt((java.nio.Buffer) o, off, v); return; }
        if (o instanceof int[]) { ((int[]) o)[(int) (off >> 2)] = v; return; }
        if (o instanceof byte[]) { byte[] b = (byte[]) o; int i = (int) off; b[i] = (byte) v; b[i + 1] = (byte) (v >> 8); b[i + 2] = (byte) (v >> 16); b[i + 3] = (byte) (v >> 24); return; }
        if (o instanceof float[]) { ((float[]) o)[(int) (off >> 2)] = Float.intBitsToFloat(v); return; }
        throw unsupported(o);
    }
    public long getLong(Object o, long off) {
        if (o == null) return Mem.getLong(Mem.ptr(off));
        if (o instanceof java.nio.Buffer && off == BUF_ADDRESS) return Mem.memAddress0((java.nio.Buffer) o);
        if (o instanceof long[]) return ((long[]) o)[(int) (off >> 3)];
        if (o instanceof double[]) return Double.doubleToRawLongBits(((double[]) o)[(int) (off >> 3)]);
        return (getInt(o, off) & 0xFFFFFFFFL) | ((long) getInt(o, off + 4) << 32);
    }
    public void putLong(Object o, long off, long v) {
        if (o == null) { Mem.putLong(Mem.ptr(off), v); return; }
        if (o instanceof long[]) { ((long[]) o)[(int) (off >> 3)] = v; return; }
        if (o instanceof double[]) { ((double[]) o)[(int) (off >> 3)] = Double.longBitsToDouble(v); return; }
        putInt(o, off, (int) v); putInt(o, off + 4, (int) (v >>> 32));
    }
    public float getFloat(Object o, long off) {
        if (o == null) return Mem.getFloat(Mem.ptr(off));
        if (o instanceof float[]) return ((float[]) o)[(int) (off >> 2)];
        return Float.intBitsToFloat(getInt(o, off));
    }
    public void putFloat(Object o, long off, float v) {
        if (o == null) { Mem.putFloat(Mem.ptr(off), v); return; }
        if (o instanceof float[]) { ((float[]) o)[(int) (off >> 2)] = v; return; }
        putInt(o, off, Float.floatToRawIntBits(v));
    }
    public double getDouble(Object o, long off) {
        if (o == null) return Mem.getDouble(Mem.ptr(off));
        if (o instanceof double[]) return ((double[]) o)[(int) (off >> 3)];
        return Double.longBitsToDouble(getLong(o, off));
    }
    public void putDouble(Object o, long off, double v) {
        if (o == null) { Mem.putDouble(Mem.ptr(off), v); return; }
        if (o instanceof double[]) { ((double[]) o)[(int) (off >> 3)] = v; return; }
        putLong(o, off, Double.doubleToRawLongBits(v));
    }
    public Object getObject(Object o, long off) {
        if (o instanceof Object[]) return ((Object[]) o)[(int) (off >> 2)];
        throw unsupported(o);
    }
    public void putObject(Object o, long off, Object v) {
        if (o instanceof Object[]) { ((Object[]) o)[(int) (off >> 2)] = v; return; }
        throw unsupported(o);
    }
    public Object getReference(Object o, long off) { return getObject(o, off); }
    public void putReference(Object o, long off, Object v) { putObject(o, off, v); }

    // volatile / ordered variants: plain (green threads)
    public int getIntVolatile(Object o, long off) { return getInt(o, off); }
    public void putIntVolatile(Object o, long off, int v) { putInt(o, off, v); }
    public long getLongVolatile(Object o, long off) { return getLong(o, off); }
    public void putLongVolatile(Object o, long off, long v) { putLong(o, off, v); }
    public Object getObjectVolatile(Object o, long off) { return getObject(o, off); }
    public void putObjectVolatile(Object o, long off, Object v) { putObject(o, off, v); }
    public void putOrderedObject(Object o, long off, Object v) { putObject(o, off, v); }
    public void putOrderedInt(Object o, long off, int v) { putInt(o, off, v); }
    public void putOrderedLong(Object o, long off, long v) { putLong(o, off, v); }
    public boolean compareAndSwapInt(Object o, long off, int e, int v) { if (getInt(o, off) != e) return false; putInt(o, off, v); return true; }
    public boolean compareAndSwapLong(Object o, long off, long e, long v) { if (getLong(o, off) != e) return false; putLong(o, off, v); return true; }
    public boolean compareAndSwapObject(Object o, long off, Object e, Object v) { if (getObject(o, off) != e) return false; putObject(o, off, v); return true; }
    public int getAndAddInt(Object o, long off, int d) { int v = getInt(o, off); putInt(o, off, v + d); return v; }
    public long getAndAddLong(Object o, long off, long d) { long v = getLong(o, off); putLong(o, off, v + d); return v; }
    public int getAndSetInt(Object o, long off, int n) { int v = getInt(o, off); putInt(o, off, n); return v; }
    public long getAndSetLong(Object o, long off, long n) { long v = getLong(o, off); putLong(o, off, n); return v; }
    public Object getAndSetObject(Object o, long off, Object n) { Object v = getObject(o, off); putObject(o, off, n); return v; }

    // ---- address-only forms
    public byte getByte(long a) { return Mem.getByte(Mem.ptr(a)); }
    public void putByte(long a, byte v) { Mem.putByte(Mem.ptr(a), v); }
    public short getShort(long a) { return Mem.getShort(Mem.ptr(a)); }
    public void putShort(long a, short v) { Mem.putShort(Mem.ptr(a), v); }
    public char getChar(long a) { return (char) Mem.getShort(Mem.ptr(a)); }
    public void putChar(long a, char v) { Mem.putShort(Mem.ptr(a), (short) v); }
    public int getInt(long a) { return Mem.getInt(Mem.ptr(a)); }
    public void putInt(long a, int v) { Mem.putInt(Mem.ptr(a), v); }
    public long getLong(long a) { return Mem.getLong(Mem.ptr(a)); }
    public void putLong(long a, long v) { Mem.putLong(Mem.ptr(a), v); }
    public float getFloat(long a) { return Mem.getFloat(Mem.ptr(a)); }
    public void putFloat(long a, float v) { Mem.putFloat(Mem.ptr(a), v); }
    public double getDouble(long a) { return Mem.getDouble(Mem.ptr(a)); }
    public void putDouble(long a, double v) { Mem.putDouble(Mem.ptr(a), v); }
    public long getAddress(long a) { return Mem.getLong(Mem.ptr(a)); }
    public void putAddress(long a, long v) { Mem.putLong(Mem.ptr(a), v); }

    // ---- memory blocks
    public long allocateMemory(long n) { return Mem.malloc((int) Math.max(1, n)); }
    public long reallocateMemory(long p, long n) { return Mem.realloc(Mem.ptr(p), (int) n); }
    public void freeMemory(long p) { if (p != 0) Mem.free(Mem.ptr(p)); }
    public void setMemory(long a, long n, byte v) { Mem.set(Mem.ptr(a), v, (int) n); }
    public void setMemory(Object o, long off, long n, byte v) {
        if (o == null) { setMemory(off, n, v); return; }
        for (long i = 0; i < n; i++) putByte(o, off + i, v);
    }
    public void copyMemory(long src, long dst, long n) { Mem.copy(Mem.ptr(dst), Mem.ptr(src), (int) n); }
    public void copyMemory(Object so, long soff, Object dobj, long doff, long n) {
        if (so == null && dobj == null) { copyMemory(soff, doff, n); return; }
        for (long i = 0; i < n; i++) putByte(dobj, doff + i, getByte(so, soff + i));
    }

    // ---- reflection-ish
    public int arrayBaseOffset(Class<?> c) { return 0; }
    public int arrayIndexScale(Class<?> c) {
        if (c == byte[].class || c == boolean[].class) return 1;
        if (c == short[].class || c == char[].class) return 2;
        if (c == long[].class || c == double[].class) return 8;
        return 4;
    }
    public long objectFieldOffset(java.lang.reflect.Field f) { throw new UnsupportedOperationException("objectFieldOffset"); }
    public long staticFieldOffset(java.lang.reflect.Field f) { throw new UnsupportedOperationException("staticFieldOffset"); }
    public Object staticFieldBase(java.lang.reflect.Field f) { throw new UnsupportedOperationException("staticFieldBase"); }
    public Object allocateInstance(Class<?> c) throws InstantiationException { throw new InstantiationException("allocateInstance " + c.getName()); }
    public int pageSize() { return 4096; }
    public int addressSize() { return 8; }
    public void throwException(Throwable t) { FakeUnsafe.<RuntimeException>sneaky(t); }
    @SuppressWarnings("unchecked") private static <T extends Throwable> void sneaky(Throwable t) throws T { throw (T) t; }
    public void loadFence() { }
    public void storeFence() { }
    public void fullFence() { }
    public void park(boolean absolute, long time) { java.util.concurrent.locks.LockSupport.parkNanos(time); }
    public void unpark(Object t) { java.util.concurrent.locks.LockSupport.unpark((Thread) t); }
    public void ensureClassInitialized(Class<?> c) { }
    public boolean shouldBeInitialized(Class<?> c) { return false; }
    public void invokeCleaner(java.nio.ByteBuffer b) { }
}
