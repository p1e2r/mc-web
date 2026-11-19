package mcweb.rt.stub;

/** mc-web: stands in for JMX monitoring (no javax.management in the browser) (MIT License). */
public final class JmxStub {
    private JmxStub() { }
    public static void registerJmxMonitoring(net.minecraft.server.MinecraftServer server) { }
}
