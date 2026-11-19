package mcweb.rt;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;

/** mc-web: read-only SeekableByteChannel over a byte[] (MIT License). */
public final class ByteArrayChannel implements SeekableByteChannel {
    private final byte[] data;
    private int pos;
    private boolean open = true;

    public ByteArrayChannel(byte[] data) { this.data = data; }

    @Override public int read(ByteBuffer dst) throws IOException {
        if (!open) throw new ClosedChannelException();
        if (pos >= data.length) return -1;
        int n = Math.min(dst.remaining(), data.length - pos);
        dst.put(data, pos, n);
        pos += n;
        return n;
    }

    @Override public int write(ByteBuffer src) { throw new NonWritableChannelException(); }
    @Override public long position() { return pos; }
    @Override public SeekableByteChannel position(long p) { pos = (int) Math.min(p, data.length); return this; }
    @Override public long size() { return data.length; }
    @Override public SeekableByteChannel truncate(long size) { throw new NonWritableChannelException(); }
    @Override public boolean isOpen() { return open; }
    @Override public void close() { open = false; }
}
