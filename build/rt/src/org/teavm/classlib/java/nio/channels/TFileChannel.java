package org.teavm.classlib.java.nio.channels;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * mc-web: FileChannel for TeaVM's virtual file system (MIT License).
 * TeaVM 0.16's RandomAccessFile misreports the length of existing files and cannot create files, so the channel keeps
 * the file's bytes in memory: loaded on open, written back on force() and close() when changed.
 */
public class TFileChannel implements SeekableByteChannel {
    private final String path;
    private final boolean writable, append;
    private byte[] data;
    private int size;
    private long pos;
    private boolean open = true, dirty;

    TFileChannel(String path, byte[] data, boolean writable, boolean append) {
        this.path = path;
        this.data = data;
        this.size = data.length;
        this.writable = writable;
        this.append = append;
    }

    static byte[] readFile(java.io.File f) throws IOException {
        try (FileInputStream in = new FileInputStream(f)) {
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream((int) Math.max(32, f.length()));
            byte[] b = new byte[65536];
            int n;
            while ((n = in.read(b)) > 0) out.write(b, 0, n);
            return out.toByteArray();
        }
    }

    public static TFileChannel open(Path path, OpenOption... options) throws IOException {
        Set<OpenOption> o = new HashSet<>(Arrays.asList(options));
        boolean write = o.contains(StandardOpenOption.WRITE) || o.contains(StandardOpenOption.APPEND);
        java.io.File f = new java.io.File(path.toString());
        boolean exists = f.isFile();
        if (o.contains(StandardOpenOption.CREATE_NEW) && exists) throw new FileAlreadyExistsException(path.toString());
        if (!exists && !(write && (o.contains(StandardOpenOption.CREATE) || o.contains(StandardOpenOption.CREATE_NEW))))
            throw new NoSuchFileException(path.toString());
        byte[] data;
        if (!exists) {
            new FileOutputStream(f).close();
            data = new byte[0];
        } else if (write && o.contains(StandardOpenOption.TRUNCATE_EXISTING)) {
            new FileOutputStream(f).close();
            data = new byte[0];
        } else {
            data = readFile(f);
        }
        TFileChannel ch = new TFileChannel(f.getPath(), data, write, o.contains(StandardOpenOption.APPEND));
        if (ch.append) ch.pos = ch.size;
        return ch;
    }

    public static TFileChannel open(Path path, Set<? extends OpenOption> options, java.nio.file.attribute.FileAttribute<?>... attrs) throws IOException {
        return open(path, options.toArray(new OpenOption[0]));
    }

    /** channel view of a stream (FileInputStream/FileOutputStream.getChannel) */
    public static TFileChannel forStream(java.io.InputStream in, java.io.OutputStream out) {
        return new TFileChannel(null, new byte[0], out != null, false) {
            long spos;
            @Override public int read(ByteBuffer dst) throws IOException {
                byte[] t = new byte[dst.remaining()]; int n = in.read(t); if (n > 0) { dst.put(t, 0, n); spos += n; } return n;
            }
            @Override public int write(ByteBuffer src) throws IOException {
                int n = src.remaining(); byte[] t = new byte[n]; src.get(t); out.write(t); spos += n; return n;
            }
            @Override public long size() throws IOException { return in != null ? spos + in.available() : spos; }
            @Override public long position() { return spos; }
            @Override public void close() throws IOException { if (in != null) in.close(); if (out != null) out.close(); }
        };
    }

    private void check() throws IOException { if (!open) throw new ClosedChannelException(); }

    private void ensure(long cap) {
        if (cap > data.length) data = Arrays.copyOf(data, (int) Math.max(cap, data.length * 2L + 64));
    }

    private int readAt(ByteBuffer dst, long at) {
        if (at >= size) return dst.hasRemaining() ? -1 : 0;
        int n = (int) Math.min(dst.remaining(), size - at);
        dst.put(data, (int) at, n);
        return n;
    }

    private int writeAt(ByteBuffer src, long at) throws IOException {
        if (!writable) throw new java.nio.channels.NonWritableChannelException();
        int n = src.remaining();
        ensure(at + n);
        if (at > size) Arrays.fill(data, size, (int) at, (byte) 0);
        src.get(data, (int) at, n);
        size = (int) Math.max(size, at + n);
        dirty = true;
        return n;
    }

    @Override public int read(ByteBuffer dst) throws IOException {
        check();
        int n = readAt(dst, pos);
        if (n > 0) pos += n;
        return n;
    }

    public int read(ByteBuffer dst, long position) throws IOException { check(); return readAt(dst, position); }

    @Override public int write(ByteBuffer src) throws IOException {
        check();
        if (append) pos = size;
        int n = writeAt(src, pos);
        pos += n;
        return n;
    }

    public int write(ByteBuffer src, long position) throws IOException { check(); return writeAt(src, position); }

    @Override public long position() throws IOException { check(); return pos; }
    @Override public TFileChannel position(long p) throws IOException { check(); pos = p; return this; }
    @Override public long size() throws IOException { check(); return size; }
    @Override public TFileChannel truncate(long newSize) throws IOException {
        check();
        if (newSize < size) { size = (int) newSize; dirty = true; }
        if (pos > newSize) pos = newSize;
        return this;
    }

    public void force(boolean metaData) throws IOException { check(); flush(); }

    private void flush() throws IOException {
        if (!dirty || path == null) return;
        try (FileOutputStream out = new FileOutputStream(path)) { out.write(data, 0, size); }
        dirty = false;
    }

    public TFileLock tryLock() throws IOException { check(); return new TFileLock(this, 0, Long.MAX_VALUE, false); }
    public TFileLock tryLock(long p, long s, boolean shared) throws IOException { check(); return new TFileLock(this, p, s, shared); }
    public TFileLock lock() throws IOException { return tryLock(); }
    public TFileLock lock(long p, long s, boolean shared) throws IOException { return tryLock(p, s, shared); }
    public long transferTo(long position, long count, java.nio.channels.WritableByteChannel target) throws IOException {
        int n = (int) Math.max(0, Math.min(count, size - position));
        return target.write(ByteBuffer.wrap(data, (int) position, n));
    }
    @Override public boolean isOpen() { return open; }
    @Override public void close() throws IOException { if (open) { flush(); open = false; } }
}
