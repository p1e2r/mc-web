package mcweb.rt;

import org.teavm.interop.Async;
import org.teavm.interop.AsyncCallback;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSByRef;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/**
 * mc-web TeaVM entry point (MIT License): fetches the game files the browser needs, mounts client.jar as a zip file
 * system, then starts Minecraft's own Main.
 */
public final class Boot {
    private Boot() { }

    public static mcweb.rt.zipfs.ZipFs vanilla;

    @JSFunctor interface SizeCb extends JSObject { void done(int size); }

    @JSBody(params = {"url", "cb"}, script = "LWJGLWeb.fetchFile(url).then(function (n) { cb(n); }, function (e) { console.warn(String(e)); cb(-1); });")
    private static native void startFetch(String url, SizeCb cb);

    @JSBody(params = {"url", "dst"}, script = "LWJGLWeb.takeFile(url, dst);")
    private static native void takeFile(String url, @JSByRef byte[] dst);

    @Async
    private static native int fetchSize(String url);

    private static void fetchSize(String url, AsyncCallback<Integer> cb) { startFetch(url, n -> cb.complete(n)); }

    public static byte[] fetch(String url) {
        byte[] b = fetchOrNull(url);
        if (b == null) throw new RuntimeException("could not fetch " + url);
        return b;
    }

    /** fetches a file relative to the page; null if it is missing. Safe to call from several threads at once. */
    public static byte[] fetchOrNull(String url) {
        int n = fetchSize(url);
        if (n < 0) return null;
        byte[] b = new byte[n];
        takeFile(url, b);
        return b;
    }

    public static void main(String[] args) throws Exception {
        long t0 = System.currentTimeMillis();
        System.setProperty("io.netty.leakDetection.level", "disabled");
        System.setProperty("io.netty.noUnsafe", "true");
        System.setProperty("io.netty.varHandle.enabled", "false"); // our VarHandle lowering ignores byteArrayView byte order
        System.setProperty("io.netty.allocator.type", "unpooled");
        System.setProperty("io.netty.recycler.maxCapacityPerThread", "0");
        System.setProperty("io.netty.processId", "1");
        System.setProperty("io.netty.machineId", "02:00:00:00:00:01");
        System.setProperty("joml.nounsafe", "true");
        System.setProperty("os.name", "Linux");
        System.setProperty("os.arch", "amd64");
        System.setProperty("os.version", "6.0");
        System.setProperty("java.vendor", "mc-web (TeaVM)");
        System.setProperty("org.lwjgl.util.NoChecks", "true");
        System.setProperty("joml.fastmath", "false");
        byte[] jar = fetch("mc/client.jar");
        vanilla = mcweb.rt.zipfs.ZipFsProvider.get().mount("client.jar", jar);
        System.out.println("[mc-web] client.jar mounted (" + (jar.length >> 20) + " MB, "
            + vanilla.data().list("/assets/minecraft").size() + " asset folders) in " + (System.currentTimeMillis() - t0) + " ms");
        new java.io.File("/mc").mkdirs();
        byte[] index = fetchOrNull("mc/assets/indexes/32.json");
        if (index != null) {
            new java.io.File("/mc/assets/indexes").mkdirs();
            java.nio.file.Files.write(java.nio.file.Paths.get("/mc/assets/indexes/32.json"), index);
            // built-in resource packs (Programmer Art, High Contrast) are zips inside the asset index; the game
            // opens them as zip file systems, so they must exist locally (they are small)
            java.util.regex.Matcher m = java.util.regex.Pattern
                .compile("\"minecraft/resourcepacks/[^\"]+\\.zip\"\\s*:\\s*\\{\\s*\"hash\"\\s*:\\s*\"([0-9a-f]{40})\"")
                .matcher(new String(index, "UTF-8"));
            while (m.find()) {
                String h = m.group(1), rel = "mc/assets/objects/" + h.substring(0, 2) + "/" + h;
                byte[] zip = fetchOrNull(rel);
                if (zip == null) continue;
                new java.io.File("/" + rel).getParentFile().mkdirs();
                java.nio.file.Files.write(java.nio.file.Paths.get("/" + rel), zip);
            }
        }
        if (args.length >= 2 && "--mcweb-server".equals(args[0])) {
            // Web Worker: run one singleplayer world's server (see McWorker)
            String level = com.google.gson.JsonParser.parseString(args[1]).getAsJsonObject().get("level").getAsString();
            Persist.restore("/mc/saves/" + level + "/");
            Persist.start();
            McWorker.serverMain(args[1]);
            return;
        }
        Persist.restore();
        Persist.start();
        java.io.File opts = new java.io.File("/mc/options.txt");
        if (!opts.exists()) {
            // browser-friendly defaults (the player can change them in Options)
            try (java.io.Writer w = new java.io.OutputStreamWriter(new java.io.FileOutputStream(opts), "UTF-8")) {
                w.write("renderDistance:4\nsimulationDistance:5\nrenderClouds:\"fast\"\nonboardAccessibility:false\n"
                    + "pauseOnLostFocus:false\ntutorialStep:none\nskipMultiplayerWarning:true\njoinedFirstServer:true\n"
                    + "entityShadows:false\nmaxFps:60\nenableVsync:false\nnarrator:0\n");
            }
        }
        net.minecraft.client.main.Main.main(args);
    }
}
