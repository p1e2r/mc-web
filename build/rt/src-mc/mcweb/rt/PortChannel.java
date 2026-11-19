package mcweb.rt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractChannel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import org.teavm.interop.Async;
import org.teavm.interop.AsyncCallback;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSByRef;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/**
 * mc-web (MIT License): a Netty channel whose bytes travel over a browser MessagePort. Used inside the Web Worker
 * that runs the singleplayer server: each page connection becomes one of these, handed to the server through
 * {@code ServerConnectionListener.acceptChannel}. Connection ids refer to the JS side (lw-net.js, worker mode).
 */
public final class PortChannel extends AbstractChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private final int id;
    private final ChannelConfig config = new DefaultChannelConfig(this);
    private volatile boolean open = true;

    public PortChannel(int id) {
        super(null);
        this.id = id;
    }

    /** Starts feeding received bytes into the pipeline (call after the channel is registered). */
    public void startReading() {
        Thread t = new Thread(() -> {
            while (open) {
                waitEvent(id, 50);
                int n;
                while ((n = nextSize(id)) >= 0) {
                    byte[] b = new byte[n];
                    take(id, b);
                    eventLoop().execute(() -> {
                        pipeline().fireChannelRead(Unpooled.wrappedBuffer(b));
                        pipeline().fireChannelReadComplete();
                    });
                }
                if (state(id) == 2 && open) {
                    eventLoop().execute(() -> close());
                    break;
                }
            }
        }, "mc-web port " + id);
        t.setDaemon(true);
        t.start();
    }

    @Override protected AbstractUnsafe newUnsafe() {
        return new AbstractUnsafe() {
            @Override public void connect(SocketAddress remote, SocketAddress local, ChannelPromise promise) {
                promise.setFailure(new UnsupportedOperationException("PortChannel is created connected"));
            }
        };
    }

    @Override protected boolean isCompatible(EventLoop loop) { return true; }
    @Override protected SocketAddress localAddress0() { return InetSocketAddress.createUnresolved("mcweb-worker", 25565); }
    @Override protected SocketAddress remoteAddress0() { return InetSocketAddress.createUnresolved("browser", id); }
    @Override protected void doBind(SocketAddress a) { }
    @Override protected void doDisconnect() { doClose(); }
    @Override protected void doClose() {
        if (open) {
            open = false;
            close(id);
        }
    }
    @Override protected void doBeginRead() { }

    @Override protected void doWrite(ChannelOutboundBuffer in) {
        // everything flushed together goes to the page as ONE message (fewer postMessage hops per tick)
        int total = 0;
        java.util.List<ByteBuf> bufs = new java.util.ArrayList<>();
        Object msg;
        while ((msg = in.current()) != null) {
            if (msg instanceof ByteBuf && ((ByteBuf) msg).isReadable()) {
                ByteBuf b = ((ByteBuf) msg).retain();
                bufs.add(b);
                total += b.readableBytes();
            }
            in.remove();
        }
        if (total == 0) { for (ByteBuf b : bufs) b.release(); return; }
        byte[] out = new byte[total];
        int off = 0;
        for (ByteBuf b : bufs) {
            int n = b.readableBytes();
            b.getBytes(b.readerIndex(), out, off, n);
            off += n;
            b.release();
        }
        send(id, out, total);
    }

    @Override public ChannelConfig config() { return config; }
    @Override public boolean isOpen() { return open; }
    @Override public boolean isActive() { return open; }
    @Override public ChannelMetadata metadata() { return METADATA; }

    // ---- JS side (lw-net.js)
    @JSFunctor interface Done extends JSObject { void done(); }

    @JSBody(params = "id", script = "return LWJGLWeb.netState(id);")
    static native int state(int id);

    @JSBody(params = "id", script = "return LWJGLWeb.netNextSize(id);")
    static native int nextSize(int id);

    @JSBody(params = {"id", "dst"}, script = "LWJGLWeb.netTake(id, dst);")
    static native void take(int id, @JSByRef byte[] dst);

    @JSBody(params = {"id", "b", "n"}, script = "LWJGLWeb.netSend(id, new Uint8Array(b.buffer, b.byteOffset, n).slice());")
    static native void send(int id, @JSByRef byte[] b, int n);

    @JSBody(params = "id", script = "LWJGLWeb.netClose(id);")
    static native void close(int id);

    @Async
    static native void waitEvent(int id, int maxMs);

    static void waitEvent(int id, int maxMs, AsyncCallback<Void> cb) { jsWait(id, maxMs, () -> cb.complete(null)); }

    @JSBody(params = {"id", "ms", "cb"}, script = "LWJGLWeb.netWait(id, ms, cb);")
    static native void jsWait(int id, int ms, Done cb);
}
