package org.teavm.classlib.java.util.concurrent;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/** mc-web: ThreadPoolExecutor for TeaVM green threads (MIT License). FIFO queue, workers created on demand up to max. */
public class TThreadPoolExecutor extends AbstractExecutorService {
    private final ArrayDeque<Runnable> queue = new ArrayDeque<>();
    private final List<Thread> workers = new ArrayList<>();
    private final BlockingQueue<Runnable> exposedQueue;
    private ThreadFactory factory;
    private RejectedExecutionHandler handler;
    private int core, max, idle, active;
    private boolean shutdown;
    private long completed;

    public TThreadPoolExecutor(int core, int max, long keepAlive, TimeUnit unit, BlockingQueue<Runnable> q) { this(core, max, keepAlive, unit, q, Executors.defaultThreadFactory(), null); }
    public TThreadPoolExecutor(int core, int max, long keepAlive, TimeUnit unit, BlockingQueue<Runnable> q, ThreadFactory f) { this(core, max, keepAlive, unit, q, f, null); }
    public TThreadPoolExecutor(int core, int max, long keepAlive, TimeUnit unit, BlockingQueue<Runnable> q, RejectedExecutionHandler h) { this(core, max, keepAlive, unit, q, Executors.defaultThreadFactory(), h); }
    public TThreadPoolExecutor(int core, int max, long keepAlive, TimeUnit unit, BlockingQueue<Runnable> q, ThreadFactory f, RejectedExecutionHandler h) {
        this.core = core; this.max = Math.max(1, Math.max(core, max)); this.exposedQueue = q; this.factory = f; this.handler = h;
    }

    @Override
    public void execute(Runnable r) {
        if (r == null) throw new NullPointerException();
        synchronized (this) {
            if (shutdown) {
                if (handler != null) { handler.rejectedExecution(r, null); return; }
                throw new RejectedExecutionException();
            }
            queue.add(r);
            if (idle == 0 && workers.size() < Math.min(max, 2)) {
                Thread t = factory.newThread(this::workLoop);
                if (t != null) { workers.add(t); t.start(); }
            }
            notifyAll();
        }
    }

    private void workLoop() {
        while (true) {
            Runnable r;
            synchronized (this) {
                while (queue.isEmpty() && !shutdown) {
                    idle++;
                    try { wait(); } catch (InterruptedException e) { idle--; return; }
                    idle--;
                }
                if (queue.isEmpty()) { notifyAll(); return; }
                r = queue.poll();
                active++;
            }
            try { beforeExecute(Thread.currentThread(), r); } catch (Throwable ignored) { }
            Throwable thrown = null;
            try { r.run(); } catch (Throwable t) { thrown = t; }
            mcweb.rt.Frame.maybeYield();
            try { afterExecute(r, thrown); } catch (Throwable ignored) { }
            if (thrown != null) {
                Thread.UncaughtExceptionHandler h = Thread.currentThread().getUncaughtExceptionHandler();
                if (h != null) h.uncaughtException(Thread.currentThread(), thrown); else thrown.printStackTrace();
            }
            synchronized (this) { active--; completed++; notifyAll(); }
        }
    }

    protected void beforeExecute(Thread t, Runnable r) { }
    protected void afterExecute(Runnable r, Throwable t) { }
    protected void terminated() { }

    @Override public synchronized void shutdown() { shutdown = true; notifyAll(); }
    @Override public synchronized List<Runnable> shutdownNow() { shutdown = true; List<Runnable> l = new ArrayList<>(queue); queue.clear(); notifyAll(); return l; }
    @Override public synchronized boolean isShutdown() { return shutdown; }
    @Override public synchronized boolean isTerminated() { return shutdown && queue.isEmpty() && active == 0; }
    public boolean isTerminating() { return shutdown && !isTerminated(); }
    @Override public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        long end = System.currentTimeMillis() + unit.toMillis(timeout);
        synchronized (this) {
            while (!isTerminated()) {
                long left = end - System.currentTimeMillis();
                if (left <= 0) return false;
                wait(left);
            }
        }
        return true;
    }
    public void close() { shutdown(); }

    public BlockingQueue<Runnable> getQueue() { return exposedQueue; }
    public synchronized int getPoolSize() { return workers.size(); }
    public synchronized int getActiveCount() { return active; }
    public synchronized int getLargestPoolSize() { return workers.size(); }
    public synchronized long getTaskCount() { return completed + active + queue.size(); }
    public synchronized long getCompletedTaskCount() { return completed; }
    public int getCorePoolSize() { return core; }
    public void setCorePoolSize(int n) { core = n; }
    public int getMaximumPoolSize() { return max; }
    public void setMaximumPoolSize(int n) { max = Math.max(1, n); }
    public void setKeepAliveTime(long t, TimeUnit u) { }
    public long getKeepAliveTime(TimeUnit u) { return 0; }
    public void allowCoreThreadTimeOut(boolean v) { }
    public boolean allowsCoreThreadTimeOut() { return false; }
    public boolean prestartCoreThread() { return false; }
    public int prestartAllCoreThreads() { return 0; }
    public ThreadFactory getThreadFactory() { return factory; }
    public void setThreadFactory(ThreadFactory f) { factory = f; }
    public RejectedExecutionHandler getRejectedExecutionHandler() { return handler; }
    public void setRejectedExecutionHandler(RejectedExecutionHandler h) { handler = h; }
    public synchronized boolean remove(Runnable r) { return queue.remove(r); }
    public void purge() { }
}
