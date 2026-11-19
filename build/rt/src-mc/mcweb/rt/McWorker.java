package mcweb.rt;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ConnectScreen;
import net.minecraft.client.gui.screens.GenericMessageScreen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.resolver.ServerAddress;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldStem;
import net.minecraft.server.packs.repository.PackRepository;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.storage.WorldData;
import org.teavm.interop.Async;
import org.teavm.interop.AsyncCallback;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/**
 * mc-web (MIT License): singleplayer on two CPU cores. The world's server runs as Minecraft's dedicated server inside
 * a Web Worker (a second copy of the game code); the page connects to it like to a multiplayer server, over a
 * MessagePort. World files go through IndexedDB: the page saves the world before handing it over and reloads it
 * when the worker has stopped.
 */
public final class McWorker {
    private McWorker() { }

    // =====================================================================================================  page side

    /** Replacement for {@code Minecraft.doWorldLoad(access, packs, stem, gameRules, newWorld)}. */
    public static void doWorldLoad(Minecraft mc, LevelStorageSource.LevelStorageAccess access, PackRepository packs,
            WorldStem stem, Optional<?> gameRules, boolean newWorld) {
        mc.disconnectWithProgressScreen();
        WorldData wd = stem.worldDataAndGenSettings().data();
        String levelId = access.getLevelId();
        String settings;
        try {
            access.saveDataTag(wd);
            // world generation settings live in data/minecraft/world_gen_settings.dat, which the server normally writes
            // on its first save; the worker's server needs it to load the world, so write it now
            net.minecraft.world.level.levelgen.WorldGenSettings gen = stem.worldDataAndGenSettings().genSettings();
            try (net.minecraft.world.level.storage.SavedDataStorage data = new net.minecraft.world.level.storage.SavedDataStorage(
                    access.getLevelPath(net.minecraft.world.level.storage.LevelResource.DATA), mc.getFixerUpper(),
                    stem.registries().compositeAccess())) {
                data.set(net.minecraft.world.level.levelgen.WorldGenSettings.TYPE, gen);
                gen.setDirty();
                data.saveAndJoin();
            }
            settings = "{\"level\":" + q(levelId)
                + ",\"name\":" + q(wd.getLevelName())
                + ",\"gamemode\":" + q(wd.getGameType().getSerializedName())
                + ",\"difficulty\":" + q(wd.getDifficulty().getSerializedName())
                + ",\"hardcore\":" + wd.isHardcore()
                + ",\"cheats\":" + wd.isAllowCommands()
                + ",\"username\":" + q(mc.getUser().getName())
                + ",\"viewDistance\":" + mc.options.renderDistance().get()
                + "}";
        } catch (Exception e) {
            throw new RuntimeException("mc-web: could not save the world before starting it", e);
        } finally {
            try { stem.close(); } catch (Exception ignored) { }
            try { access.close(); } catch (Exception ignored) { }
        }
        String prefix = "/mc/saves/" + levelId + "/";
        Persist.lock(prefix);
        Persist.flush(prefix);
        mc.gui.setScreen(new GenericMessageScreen(Component.literal("Starting world\u2026 (first start takes up to a minute)")));
        String levelName = wd.getLevelName();
        // boot the worker from a background thread so the game keeps rendering meanwhile
        Thread starter = new Thread(() -> {
            boolean ok = startWorker(settings);
            mc.execute(() -> {
                if (!ok) {
                    Persist.unlock(prefix);
                    mc.gui.setScreen(new TitleScreen());
                    return;
                }
                ServerData data = new ServerData(levelName, "mcweb-worker", ServerData.Type.OTHER);
                ConnectScreen.startConnecting(new TitleScreen(), mc, ServerAddress.parseString("mcweb-worker"), data, false, null);
            });
            if (!ok) return;
            // when the worker has saved and stopped, reload the world's files so the world list is up to date
            waitWorkerStopped();
            Persist.reload(prefix);
            Persist.unlock(prefix);
            // leaving a singleplayer world ends on the title screen (not the multiplayer list)
            mc.execute(() -> {
                if (mc.level == null) mc.gui.setScreen(new TitleScreen());
            });
        }, "mc-web world starter");
        starter.setDaemon(true);
        starter.start();
    }

    private static String q(String s) {
        StringBuilder b = new StringBuilder("\"");
        for (char c : s.toCharArray()) {
            if (c == '"' || c == '\\') b.append('\\').append(c);
            else if (c < 0x20) b.append(String.format("\\u%04x", (int) c));
            else b.append(c);
        }
        return b.append('"').toString();
    }

    @JSFunctor interface BoolCb extends JSObject { void done(boolean ok); }
    @JSFunctor interface Done extends JSObject { void done(); }

    @Async
    private static native boolean startWorker(String settings);

    private static void startWorker(String settings, AsyncCallback<Boolean> cb) { jsStartWorker(settings, ok -> cb.complete(ok)); }

    @JSBody(params = {"settings", "cb"}, script = "LWJGLWeb.worldWorkerStart(settings).then(function () { cb(true); }, "
        + "function (e) { console.error('[mc-web] world worker failed to start', e); cb(false); });")
    private static native void jsStartWorker(String settings, BoolCb cb);

    @Async
    private static native void waitWorkerStopped();

    private static void waitWorkerStopped(AsyncCallback<Void> cb) { jsWaitStopped(() -> cb.complete(null)); }

    @JSBody(params = "cb", script = "LWJGLWeb.worldWorkerStopped().then(function () { cb(); });")
    private static native void jsWaitStopped(Done cb);

    // ===================================================================================================  worker side

    private static volatile MinecraftServer server;

    /** Replacement for {@code MinecraftServer.spin}: remembers the server so the worker can hand it connections. */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static MinecraftServer spin(java.util.function.Function fn) {
        MinecraftServer s = MinecraftServer.spin(fn);
        server = s;
        return s;
    }

    /** Worker entry: start the dedicated server for one world and accept page connections. */
    public static void serverMain(String settingsJson) throws Exception {
        com.google.gson.JsonObject s = com.google.gson.JsonParser.parseString(settingsJson).getAsJsonObject();
        String level = s.get("level").getAsString();
        String user = s.get("username").getAsString();
        boolean cheats = s.get("cheats").getAsBoolean();
        String uuid = mcweb.rt.game.GameBridge.offlineUuid(user);
        int view = Math.max(2, Math.min(32, s.get("viewDistance").getAsInt()));
        String props = "online-mode=false\nenforce-secure-profile=false\nprevent-proxy-connections=false\n"
            + "level-name=" + level + "\ngamemode=" + s.get("gamemode").getAsString()
            + "\ndifficulty=" + s.get("difficulty").getAsString() + "\nhardcore=" + s.get("hardcore").getAsBoolean()
            + "\nview-distance=" + view + "\nsimulation-distance=" + Math.min(view, 8)
            + "\nmax-tick-time=-1\npause-when-empty-seconds=0\nspawn-protection=0\nmax-players=8\n"
            + "network-compression-threshold=-1\nrate-limit=0\nsync-chunk-writes=false\nenable-status=false\n"
            + "enable-query=false\nenable-rcon=false\nenable-jmx-monitoring=false\nallow-flight=true\n"
            + "op-permission-level=4\nmotd=" + level + "\n";
        Files.write(Paths.get("/server.properties"), props.getBytes(StandardCharsets.UTF_8));
        // singleplayer runs Minecraft's own server internally (the same code the integrated server uses)
        Files.write(Paths.get("/eula.txt"), "eula=true\n".getBytes(StandardCharsets.UTF_8));
        String ops = cheats ? "[{\"uuid\":\"" + uuid + "\",\"name\":\"" + user + "\",\"level\":4,\"bypassesPlayerLimit\":true}]" : "[]";
        Files.write(Paths.get("/ops.json"), ops.getBytes(StandardCharsets.UTF_8));

        net.minecraft.server.Main.main(new String[]{"--nogui", "--universe", "/mc/saves", "--world", level});

        Thread acceptor = new Thread(() -> acceptLoop(user), "mc-web worker accept");
        acceptor.setDaemon(true);
        acceptor.start();
    }

    private static void acceptLoop(String user) {
        while (server == null || !server.isReady()) {
            if (server != null && !server.isRunning() && server.isReady()) break;
            try { Thread.sleep(100); } catch (InterruptedException e) { return; }
        }
        workerReady();
        while (true) {
            int ev = waitWorkerEvent();          // >0: new connection id, -1: stop requested
            if (ev == -1) {
                System.out.println("[mc-web] stopping the world");
                try { server.halt(true); } catch (Throwable t) { System.err.println("[mc-web] halt: " + t); }
                Persist.syncNow();
                workerStopped();
                return;
            }
            if (ev > 0) {
                PortChannel ch = new PortChannel(ev);
                mcweb.rt.game.GameBridge.acceptChannel(server, ch, user);
                ch.startReading();
            }
        }
    }

    @JSBody(script = "LWJGLWeb.workerPost({type: 'ready'});")
    private static native void workerReady();

    @JSBody(script = "LWJGLWeb.workerStoppedSaved();")
    private static native void workerStopped();

    @Async
    private static native int waitWorkerEvent();

    private static void waitWorkerEvent(AsyncCallback<Integer> cb) { jsWaitEvent(n -> cb.complete(n)); }

    @JSFunctor interface IntCb extends JSObject { void done(int n); }

    @JSBody(params = "cb", script = "LWJGLWeb.workerNextEvent(cb);")
    private static native void jsWaitEvent(IntCb cb);
}
