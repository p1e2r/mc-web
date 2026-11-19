package mcweb.rt.stub;

/** mc-web: stands in for the dedicated server's Swing window (no GUI in a Web Worker) (MIT License). */
public final class ServerGuiStub {
    private ServerGuiStub() { }
    public static ServerGuiStub showFrameFor(net.minecraft.server.dedicated.DedicatedServer server) { return null; }
    public void close() { }
    public void start() { }
    public void addFinalizer(Runnable r) { }
}
