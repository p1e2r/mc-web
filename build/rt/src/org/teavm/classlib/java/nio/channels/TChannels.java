package org.teavm.classlib.java.nio.channels;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/** mc-web: java.nio.channels.Channels (MIT License). */
public final class TChannels {
    private TChannels() { }

    public static InputStream newInputStream(ReadableByteChannel ch) {
        return new InputStream() {
            @Override public int read() throws IOException { byte[] b = new byte[1]; int n = read(b, 0, 1); return n <= 0 ? -1 : b[0] & 0xff; }
            @Override public int read(byte[] b, int off, int len) throws IOException { return ch.read(ByteBuffer.wrap(b, off, len)); }
            @Override public void close() throws IOException { ch.close(); }
        };
    }
    public static OutputStream newOutputStream(WritableByteChannel ch) {
        return new OutputStream() {
            @Override public void write(int b) throws IOException { write(new byte[]{(byte) b}, 0, 1); }
            @Override public void write(byte[] b, int off, int len) throws IOException { ByteBuffer bb = ByteBuffer.wrap(b, off, len); while (bb.hasRemaining()) ch.write(bb); }
            @Override public void close() throws IOException { ch.close(); }
        };
    }
    public static ReadableByteChannel newChannel(InputStream in) {
        return new ReadableByteChannel() {
            boolean open = true;
            public int read(ByteBuffer dst) throws IOException {
                byte[] tmp = new byte[dst.remaining()];
                int n = in.read(tmp);
                if (n > 0) dst.put(tmp, 0, n);
                return n;
            }
            public boolean isOpen() { return open; }
            public void close() throws IOException { open = false; in.close(); }
        };
    }
    public static WritableByteChannel newChannel(OutputStream out) {
        return new WritableByteChannel() {
            boolean open = true;
            public int write(ByteBuffer src) throws IOException { int n = src.remaining(); byte[] tmp = new byte[n]; src.get(tmp); out.write(tmp); return n; }
            public boolean isOpen() { return open; }
            public void close() throws IOException { open = false; out.close(); }
        };
    }
    public static Reader newReader(ReadableByteChannel ch, Charset cs) { return new InputStreamReader(newInputStream(ch), cs); }
    public static Writer newWriter(WritableByteChannel ch, Charset cs) { return new OutputStreamWriter(newOutputStream(ch), cs); }
}
