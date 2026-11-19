package org.teavm.classlib.java.util.concurrent.locks;

import java.util.IdentityHashMap;
import org.teavm.interop.Async;
import org.teavm.jso.browser.Window;
import org.teavm.interop.AsyncCallback;

/** mc-web: LockSupport for TeaVM green threads (MIT License). Permits are per thread; the Thread object is the monitor. */
public final class TLockSupport {
    private static final IdentityHashMap<Thread, Boolean> permits = new IdentityHashMap<>();
    private static final IdentityHashMap<Thread, Object> blockers = new IdentityHashMap<>();

    private TLockSupport() { }

    /** a parked thread: resumed by unpark (via a 0 ms timer, never synchronously) or by its timeout. */
    private static final class Waiter {
        AsyncCallback<Void> cb;
        int timer = -1;
        boolean done;
    }
    private static final IdentityHashMap<Thread, Waiter> waiting = new IdentityHashMap<>();

    public static void unpark(Thread t) {
        if (t == null) return;
        Waiter w = waiting.get(t);
        if (w != null) {
            if (!w.done) Window.setTimeout(() -> wake(t, w), 0);
        } else {
            permits.put(t, Boolean.TRUE);
        }
    }

    private static void wake(Thread t, Waiter w) {
        if (w.done) return;
        w.done = true;
        if (w.timer >= 0) Window.clearTimeout(w.timer);
        if (waiting.get(t) == w) waiting.remove(t);
        w.cb.complete(null);
    }

    @Async
    private static native void block(Thread t, double ms);

    private static void block(Thread t, double ms, AsyncCallback<Void> cb) {
        Waiter w = new Waiter();
        w.cb = cb;
        waiting.put(t, w);
        if (ms > 0) w.timer = Window.setTimeout(() -> wake(t, w), ms);
    }

    /** absolute: deadline in ms since epoch; otherwise relative nanos (0 = forever). */
    public static void mcwebPark(boolean absolute, long time) {
        Thread t = Thread.currentThread();
        double ms;
        if (absolute) {
            ms = time - System.currentTimeMillis();
            if (ms <= 0) return;
        } else {
            if (time < 0) return;
            ms = time == 0 ? 0 : Math.max(0.001, time / 1e6);
        }
        if (permits.remove(t) != null) return;
        if (t.isInterrupted()) return;
        block(t, ms);
    }

    public static void park() { mcwebPark(false, 0); }
    public static void park(Object blocker) { setBlocker(blocker); mcwebPark(false, 0); setBlocker(null); }
    public static void parkNanos(long nanos) { if (nanos > 0) mcwebPark(false, nanos); }
    public static void parkNanos(Object blocker, long nanos) { if (nanos > 0) { setBlocker(blocker); mcwebPark(false, nanos); setBlocker(null); } }
    public static void parkUntil(long deadline) { mcwebPark(true, deadline); }
    public static void parkUntil(Object blocker, long deadline) { setBlocker(blocker); mcwebPark(true, deadline); setBlocker(null); }
    public static long getThreadId(Thread t) { return t.getId(); }
    public static Object getBlocker(Thread t) { return blockers.get(t); }
    public static void setCurrentBlocker(Object blocker) { setBlocker(blocker); }

    private static void setBlocker(Object b) {
        if (b == null) blockers.remove(Thread.currentThread());
        else blockers.put(Thread.currentThread(), b);
    }
}
