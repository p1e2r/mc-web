package org.teavm.classlib.java.util.concurrent;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * mc-web: ForkJoinPool for TeaVM green threads (MIT License). Fork/join tasks run inline on the calling thread;
 * plain executor jobs go to a FIFO queue served by up to MAX_WORKERS worker threads made by the thread factory.
 */
public class TForkJoinPool extends AbstractExecutorService {
    private static final int MAX_WORKERS = 2;
    private static TForkJoinPool common;

    public interface ForkJoinWorkerThreadFactory {
        TForkJoinWorkerThread newThread(TForkJoinPool pool);
    }

    public interface ManagedBlocker {
        boolean block() throws InterruptedException;
        boolean isReleasable();
    }

    public static final ForkJoinWorkerThreadFactory defaultForkJoinWorkerThreadFactory = p -> new TForkJoinWorkerThread(p) { };

    private final int parallelism;
    private final ForkJoinWorkerThreadFactory factory;
    private final Thread.UncaughtExceptionHandler handler;
    private final ArrayDeque<Runnable> queue = new ArrayDeque<>();
    private final List<Thread> workers = new ArrayList<>();
    private int idle;
    private int blocked;
    private boolean shutdown;
    int nextIndex;

    public TForkJoinPool() { this(1); }
    public TForkJoinPool(int parallelism) { this(parallelism, defaultForkJoinWorkerThreadFactory, null, false); }
    public TForkJoinPool(int parallelism, ForkJoinWorkerThreadFactory factory, Thread.UncaughtExceptionHandler handler, boolean asyncMode) {
        this.parallelism = Math.max(1, parallelism);
        this.factory = factory != null ? factory : defaultForkJoinWorkerThreadFactory;
        this.handler = handler;
    }

    public static TForkJoinPool commonPool() {
        if (common == null) common = new TForkJoinPool(1);
        return common;
    }
    public static int getCommonPoolParallelism() { return 1; }
    public int getParallelism() { return parallelism; }
    public int getPoolSize() { return workers.size(); }
    public boolean getAsyncMode() { return false; }
    public int getActiveThreadCount() { return workers.size() - idle; }
    public int getRunningThreadCount() { return workers.size() - idle; }
    public long getQueuedTaskCount() { return queue.size(); }
    public int getQueuedSubmissionCount() { return queue.size(); }
    public boolean hasQueuedSubmissions() { return !queue.isEmpty(); }
    public boolean isQuiescent() { return queue.isEmpty() && idle == workers.size(); }
    public Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() { return handler; }

    public <T> T invoke(TForkJoinTask<T> task) { return task.invoke(); }
    public void execute(TForkJoinTask<?> task) { execute((Runnable) task::invoke); }
    public <T> TForkJoinTask<T> submit(TForkJoinTask<T> task) { execute(task); return task; }

    @Override
    public void execute(Runnable r) {
        if (r == null) throw new NullPointerException();
        synchronized (this) {
            if (shutdown) throw new RejectedExecutionException();
            queue.add(r);
            if (idle == 0 && workers.size() - blocked < Math.min(parallelism, MAX_WORKERS)) spawnWorker();
            notifyAll();
        }
    }

    private void spawnWorker() {
        TForkJoinWorkerThread w = factory.newThread(this);
        if (w != null) {
            workers.add(w);
            if (handler != null) w.setUncaughtExceptionHandler(handler);
            w.start();
        }
    }

    void workLoop() {
        while (true) {
            Runnable r;
            synchronized (this) {
                while (queue.isEmpty() && !shutdown) {
                    idle++;
                    try { wait(); } catch (InterruptedException e) { idle--; return; }
                    idle--;
                }
                if (queue.isEmpty()) return;
                r = queue.poll();
            }
            try {
                r.run();
            } catch (Throwable t) {
                Thread.UncaughtExceptionHandler h = handler != null ? handler : Thread.getDefaultUncaughtExceptionHandler();
                if (h != null) h.uncaughtException(Thread.currentThread(), t);
                else t.printStackTrace();
            }
            mcweb.rt.Frame.maybeYield();
        }
    }

    public static void managedBlock(ManagedBlocker blocker) throws InterruptedException {
        if (blocker.isReleasable()) return;
        Thread t = Thread.currentThread();
        TForkJoinPool p = t instanceof TForkJoinWorkerThread ? ((TForkJoinWorkerThread) t).pool : null;
        if (p != null) p.beginBlocked();
        try {
            while (!blocker.isReleasable() && !blocker.block()) { }
        } finally {
            if (p != null) p.endBlocked();
        }
    }

    /** a worker is about to block: like the JDK, compensate with another worker so queued tasks it waits on can run. */
    private synchronized void beginBlocked() {
        blocked++;
        if (idle == 0 && !shutdown && workers.size() - blocked < Math.min(parallelism, MAX_WORKERS)) spawnWorker();
    }

    private synchronized void endBlocked() { blocked--; }

    static void helpAsyncBlocker(java.util.concurrent.Executor e, ManagedBlocker b) { }
    @Override public synchronized void shutdown() { shutdown = true; notifyAll(); }
    @Override public synchronized List<Runnable> shutdownNow() { shutdown = true; List<Runnable> l = new ArrayList<>(queue); queue.clear(); notifyAll(); return l; }
    @Override public synchronized boolean isShutdown() { return shutdown; }
    @Override public synchronized boolean isTerminated() { return shutdown && queue.isEmpty() && idle == workers.size(); }
    public boolean isTerminating() { return shutdown && !isTerminated(); }
    @Override public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        long end = System.currentTimeMillis() + unit.toMillis(timeout);
        while (!isTerminated() && System.currentTimeMillis() < end) Thread.sleep(5);
        return isTerminated();
    }
    public boolean awaitQuiescence(long timeout, TimeUnit unit) {
        long end = System.currentTimeMillis() + unit.toMillis(timeout);
        try { while (!isQuiescent() && System.currentTimeMillis() < end) Thread.sleep(5); } catch (InterruptedException e) { return false; }
        return isQuiescent();
    }
    public void close() { shutdown(); }
}
