package mcweb.rt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.channel.embedded.EmbeddedChannel;
import java.net.InetSocketAddress;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.PacketFlow;
import org.teavm.interop.Async;
import org.teavm.interop.AsyncCallback;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSByRef;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/**
 * mc-web multiplayer (MIT License). Browsers cannot open TCP sockets, so a server connection is a WebSocket to the
 * mc-web relay, which forwards the bytes to the Minecraft server. On the Java side it is a Netty EmbeddedChannel
 * carrying Minecraft's normal client pipeline (framing, compression, packet codecs, Connection).
 */
public final class McNet {
    private McNet() { }

    /** Replacement for {@code Connection.connect(InetSocketAddress, EventLoopGroupHolder, Connection)}. */
    public static ChannelFuture connect(InetSocketAddress address, net.minecraft.server.network.EventLoopGroupHolder holder,
            Connection connection) {
        String target = address.getHostString() + ":" + address.getPort();
        int id = open(target);
        waitOpen(id);
        if (state(id) != 1) {
            String why = reason(id);
            close(id);
            EmbeddedChannel dead = new EmbeddedChannel();
            return dead.newFailedFuture(new java.net.ConnectException(why == null || why.isEmpty() ? "Could not connect to " + target : why));
        }
        EmbeddedChannel ch = new EmbeddedChannel(new ChannelInitializer<Channel>() {
            @Override
            protected void initChannel(Channel c) {
                // bytes leaving the pipeline go to the WebSocket
                c.pipeline().addFirst("mcweb-ws", new ChannelOutboundHandlerAdapter() {
                    // packets written between two flushes go out as ONE WebSocket message (one frame through the
                    // tunnel, one TCP write at the relay) instead of one message per packet
                    private final io.netty.buffer.CompositeByteBuf pending = Unpooled.compositeBuffer(1024);

                    @Override
                    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
                        if (msg instanceof ByteBuf) {
                            ByteBuf b = (ByteBuf) msg;
                            if (b.isReadable()) pending.addComponent(true, b); else b.release();
                            promise.setSuccess();
                        } else {
                            ctx.write(msg, promise);
                        }
                    }

                    @Override
                    public void flush(ChannelHandlerContext ctx) {
                        int n = pending.readableBytes();
                        if (n > 0) {
                            byte[] out = new byte[n];
                            pending.readBytes(out);
                            send(id, out, n);
                        }
                        pending.discardReadComponents();   // releases the packets that were just sent
                        ctx.flush();
                    }

                    @Override
                    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
                        flush(ctx);
                        pending.release();
                        McNet.close(id);
                        super.close(ctx, promise);
                    }
                });
                Connection.configureSerialization(c.pipeline(), PacketFlow.CLIENTBOUND, false, null);
                connection.configurePacketHandler(c.pipeline());
            }
        });
        Thread pump = new Thread(() -> pump(id, ch), "mc-web net " + target);
        pump.setDaemon(true);
        pump.start();
        return ch.newSucceededFuture();
    }

    /** Feeds received bytes into the channel and runs Netty's queued tasks until the socket closes. */
    private static void pump(int id, EmbeddedChannel ch) {
        try {
            while (ch.isOpen()) {
                waitEvent(id, 20);
                int n;
                while ((n = nextSize(id)) >= 0) {
                    byte[] b = new byte[n];
                    take(id, b);
                    try {
                        ch.writeInbound(Unpooled.wrappedBuffer(b));
                    } catch (Throwable t) {
                        System.err.println("[mc-web] network: " + t);
                    }
                }
                try {
                    ch.runPendingTasks();
                } catch (Throwable t) {
                    System.err.println("[mc-web] network task: " + t);
                }
                if (state(id) == 2) {
                    System.out.println("[mc-web] connection closed: " + reason(id));
                    ch.pipeline().fireChannelInactive();
                    ch.close();
                    break;
                }
            }
        } finally {
            close(id);
        }
    }

    @JSFunctor interface Done extends JSObject { void done(); }

    @JSBody(params = "target", script = "return LWJGLWeb.netOpen(target);")
    private static native int open(String target);

    @JSBody(params = "id", script = "return LWJGLWeb.netState(id);")
    private static native int state(int id);

    @JSBody(params = "id", script = "return LWJGLWeb.netReason(id);")
    private static native String reason(int id);

    @JSBody(params = "id", script = "return LWJGLWeb.netNextSize(id);")
    private static native int nextSize(int id);

    @JSBody(params = {"id", "dst"}, script = "LWJGLWeb.netTake(id, dst);")
    private static native void take(int id, @JSByRef byte[] dst);

    @JSBody(params = {"id", "b", "n"}, script = "LWJGLWeb.netSend(id, new Uint8Array(b.buffer, b.byteOffset, n).slice());")
    private static native void send(int id, @JSByRef byte[] b, int n);

    @JSBody(params = "id", script = "LWJGLWeb.netClose(id);")
    private static native void close(int id);

    @Async
    private static native void waitOpen(int id);

    private static void waitOpen(int id, AsyncCallback<Void> cb) { jsWaitOpen(id, () -> cb.complete(null)); }

    @JSBody(params = {"id", "cb"}, script = "LWJGLWeb.netWaitOpen(id, cb);")
    private static native void jsWaitOpen(int id, Done cb);

    @Async
    private static native void waitEvent(int id, int maxMs);

    private static void waitEvent(int id, int maxMs, AsyncCallback<Void> cb) { jsWait(id, maxMs, () -> cb.complete(null)); }

    @JSBody(params = {"id", "ms", "cb"}, script = "LWJGLWeb.netWait(id, ms, cb);")
    private static native void jsWait(int id, int ms, Done cb);
}
