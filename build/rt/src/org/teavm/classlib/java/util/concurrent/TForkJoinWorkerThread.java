package org.teavm.classlib.java.util.concurrent;

/** mc-web: worker thread of TForkJoinPool (MIT License). */
public class TForkJoinWorkerThread extends Thread {
    final TForkJoinPool pool;
    final int index;

    protected TForkJoinWorkerThread(TForkJoinPool pool) {
        this.pool = pool;
        this.index = pool.nextIndex++;
        setDaemon(true);
    }

    public TForkJoinPool getPool() { return pool; }
    public int getPoolIndex() { return index; }
    protected void onStart() { }
    protected void onTermination(Throwable exception) { }

    @Override
    public void run() {
        Throwable ex = null;
        try {
            onStart();
            pool.workLoop();
        } catch (Throwable t) {
            ex = t;
        } finally {
            onTermination(ex);
        }
    }
}
