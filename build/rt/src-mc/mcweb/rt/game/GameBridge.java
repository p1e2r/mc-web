package mcweb.rt.game;

import io.netty.channel.Channel;
import net.minecraft.core.UUIDUtil;
import net.minecraft.server.MinecraftServer;

/**
 * mc-web (MIT License): calls that pass game types the patcher remaps (java.util.UUID -> mcweb.rt.UUID). This class is
 * patched together with the game jars (see build-round.sh), so its signatures match the patched game.
 */
public final class GameBridge {
    private GameBridge() { }

    public static void acceptChannel(Object server, Object channel, String user) {
        ((MinecraftServer) server).getConnection().acceptChannel((Channel) channel, UUIDUtil.createOfflinePlayerUUID(user));
    }

    public static String offlineUuid(String user) {
        return UUIDUtil.createOfflinePlayerUUID(user).toString();
    }
}
