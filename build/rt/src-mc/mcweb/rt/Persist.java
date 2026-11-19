package mcweb.rt;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.teavm.interop.Async;
import org.teavm.interop.AsyncCallback;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSByRef;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/**
 * mc-web: keeps worlds and settings across page reloads (MIT License). The game's file system lives in memory;
 * at boot every stored file is written back into it, and a background thread copies changed files to the
 * browser's IndexedDB every few seconds.
 */
public final class Persist {
    private static final String[] ROOTS = {"/mc/saves", "/mc/options.txt", "/mc/servers.dat", "/mc/screenshots"};
    private static final Map<String, Integer> known = new HashMap<>();

    private Persist() { }

    private static volatile String locked;   // a world currently owned by the worker: not synced from here

    public static void lock(String prefix) { locked = prefix; }
    public static void unlock(String prefix) { if (prefix.equals(locked)) locked = null; }

    /** Writes the files under {@code prefix} to IndexedDB now and waits until they are stored. */
    public static void flush(String prefix) {
        try {
            HashSet<String> seen = new HashSet<>();
            walk(new File(prefix), seen, true);
        } catch (Exception e) {
            System.err.println("[mc-web] flush " + prefix + ": " + e);
        }
        waitIdle();
    }

    /** Syncs everything now and waits until IndexedDB has stored it (worker shutdown). */
    public static void syncNow() {
        try { sync(); } catch (Exception e) { System.err.println("[mc-web] sync: " + e); }
        waitIdle();
    }

    /** Replaces the in-memory copy of {@code prefix} with what IndexedDB holds (after the worker saved it). */
    public static void reload(String prefix) {
        deleteTree(new File(prefix));
        for (String k : new HashSet<>(known.keySet())) if (k.startsWith(prefix)) known.remove(k);
        restore(prefix);
    }

    private static void deleteTree(File f) {
        File[] kids = f.listFiles();
        if (kids != null) for (File k : kids) deleteTree(k);
        f.delete();
    }

    /** Restores stored files into the in-memory file system. Call before the game starts. */
    public static void restore() { restore(""); }

    public static void restore(String prefix) {
        int n = loadAll(prefix);
        if (n <= 0) return;
        int ok = 0;
        for (int i = 0; i < n; i++) {
            String path = key(i);
            if (!path.startsWith(prefix)) { skip(i); continue; }
            byte[] b = new byte[size(i)];
            take(i, b);
            try {
                File f = new File(path);
                if (f.getParentFile() != null) f.getParentFile().mkdirs();
                Files.write(java.nio.file.Paths.get(path), b);
                known.put(path, Arrays.hashCode(b));
                ok++;
            } catch (Exception e) {
                System.err.println("[mc-web] could not restore " + path + ": " + e);
            }
        }
        done();
        System.out.println("[mc-web] restored " + ok + " saved files" + (prefix.isEmpty() ? "" : " under " + prefix));
    }

    /** Starts the background sync thread. */
    public static void start() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    sync();
                } catch (Throwable e) {
                    System.err.println("[mc-web] save sync failed: " + e);
                }
            }
        }, "mc-web save sync");
        t.setDaemon(true);
        t.start();
    }

    private static void sync() throws Exception {
        HashSet<String> seen = new HashSet<>();
        for (String r : ROOTS) walk(new File(r), seen, false);
        String lk = locked;
        for (String gone : new HashSet<>(known.keySet())) {
            if (lk != null && gone.startsWith(lk)) continue;
            if (!seen.contains(gone)) {
                known.remove(gone);
                delete(gone);
            }
        }
    }

    private static void walk(File f, HashSet<String> seen, boolean force) throws Exception {
        if (!f.exists()) return;
        String path = f.getPath().replace('\\', '/');
        String lk = locked;
        if (!force && lk != null && (path + "/").startsWith(lk)) return;
        if (f.isDirectory()) {
            File[] kids = f.listFiles();
            if (kids != null) for (File k : kids) walk(k, seen, force);
            return;
        }
        if (path.endsWith("session.lock")) return;
        seen.add(path);
        byte[] b = Files.readAllBytes(java.nio.file.Paths.get(path));
        int h = Arrays.hashCode(b) * 31 + b.length;
        Integer old = known.get(path);
        if (old != null && old == h) return;
        known.put(path, h);
        put(path, b, b.length);
        Frame.maybeYield();
    }

    @JSFunctor interface IntCb extends JSObject { void done(int n); }

    @Async
    private static native int loadAll(String prefix);

    private static void loadAll(String prefix, AsyncCallback<Integer> cb) {
        startLoad(prefix, n -> cb.complete(n));
    }

    @Async
    private static native void waitIdle();

    private static void waitIdle(AsyncCallback<Void> cb) { jsWaitIdle(() -> cb.complete(null)); }

    @JSFunctor interface Done extends JSObject { void done(); }

    @JSBody(params = "cb", script = "LWJGLWeb.idbWaitIdle(cb);")
    private static native void jsWaitIdle(Done cb);

    @JSBody(params = "i", script = "LWJGLWeb.idbLoaded[i][1] = null;")
    private static native void skip(int i);

    @JSBody(params = {"prefix", "cb"}, script = "if (!globalThis.indexedDB || !LWJGLWeb.idbLoadAll) { cb(-1); return; }"
        + "LWJGLWeb.idbLoadAll(prefix).then(function (n) { cb(n); }, function (e) { console.warn('[mc-web] saved games unavailable', e); cb(-1); });")
    private static native void startLoad(String prefix, IntCb cb);

    @JSBody(params = "i", script = "return LWJGLWeb.idbKey(i);")
    private static native String key(int i);

    @JSBody(params = "i", script = "return LWJGLWeb.idbSize(i);")
    private static native int size(int i);

    @JSBody(params = {"i", "dst"}, script = "LWJGLWeb.idbTake(i, dst);")
    private static native void take(int i, @JSByRef byte[] dst);

    @JSBody(script = "LWJGLWeb.idbDone();")
    private static native void done();

    @JSBody(params = {"path", "b", "len"}, script = "LWJGLWeb.idbPut(path, new Uint8Array(b.buffer, b.byteOffset, len).slice());")
    private static native void put(String path, @JSByRef byte[] b, int len);

    @JSBody(params = "path", script = "LWJGLWeb.idbDelete(path);")
    private static native void delete(String path);
}
