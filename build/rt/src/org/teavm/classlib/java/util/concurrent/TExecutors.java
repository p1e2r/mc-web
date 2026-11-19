package org.teavm.classlib.java.util.concurrent;

import java.util.concurrent.*;

/** mc-web: Executors for TeaVM green threads (MIT License). */
public class TExecutors {
    private static int poolNumber = 1;

    public static ExecutorService newFixedThreadPool(int n) { return new TThreadPoolExecutor(n, n, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>()); }
    public static ExecutorService newFixedThreadPool(int n, ThreadFactory f) { return new TThreadPoolExecutor(n, n, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), f); }
    public static ExecutorService newSingleThreadExecutor() { return newFixedThreadPool(1); }
    public static ExecutorService newSingleThreadExecutor(ThreadFactory f) { return newFixedThreadPool(1, f); }
    public static ExecutorService newCachedThreadPool() { return new TThreadPoolExecutor(0, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>()); }
    public static ExecutorService newCachedThreadPool(ThreadFactory f) { return new TThreadPoolExecutor(0, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), f); }
    public static ExecutorService newWorkStealingPool() { return new TForkJoinPool(1); }
    public static ExecutorService newWorkStealingPool(int n) { return new TForkJoinPool(n); }
    public static ScheduledExecutorService newSingleThreadScheduledExecutor() { return new TScheduledThreadPoolExecutor(1); }
    public static ScheduledExecutorService newSingleThreadScheduledExecutor(ThreadFactory f) { return new TScheduledThreadPoolExecutor(1, f); }
    public static ScheduledExecutorService newScheduledThreadPool(int n) { return new TScheduledThreadPoolExecutor(n); }
    public static ScheduledExecutorService newScheduledThreadPool(int n, ThreadFactory f) { return new TScheduledThreadPoolExecutor(n, f); }
    public static ExecutorService unconfigurableExecutorService(ExecutorService e) { return e; }
    public static ScheduledExecutorService unconfigurableScheduledExecutorService(ScheduledExecutorService e) { return e; }

    public static ThreadFactory defaultThreadFactory() {
        final int pool = poolNumber++;
        return new ThreadFactory() {
            int n = 1;
            public Thread newThread(Runnable r) { Thread t = new Thread(r, "pool-" + pool + "-thread-" + n++); t.setDaemon(false); return t; }
        };
    }

    public static <T> Callable<T> callable(Runnable task, T result) { return () -> { task.run(); return result; }; }
    public static Callable<Object> callable(Runnable task) { return () -> { task.run(); return null; }; }
}
