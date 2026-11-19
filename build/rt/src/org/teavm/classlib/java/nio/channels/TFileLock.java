package org.teavm.classlib.java.nio.channels;

/** mc-web: FileLock (single tab, single process: locks always succeed). MIT License. */
public class TFileLock implements AutoCloseable {
    private final TFileChannel channel;
    private final long position, size;
    private final boolean shared;
    private boolean valid = true;
    protected TFileLock(TFileChannel channel, long position, long size, boolean shared) { this.channel = channel; this.position = position; this.size = size; this.shared = shared; }
    public final TFileChannel channel() { return channel; }
    public final long position() { return position; }
    public final long size() { return size; }
    public final boolean isShared() { return shared; }
    public boolean isValid() { return valid && channel.isOpen(); }
    public void release() { valid = false; }
    @Override public final void close() { release(); }
}
