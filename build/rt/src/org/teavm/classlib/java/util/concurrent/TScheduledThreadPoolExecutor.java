package org.teavm.classlib.java.util.concurrent;

import java.util.PriorityQueue;
import java.util.concurrent.*;

/** mc-web: ScheduledThreadPoolExecutor with one timer thread (MIT License). */
public class TScheduledThreadPoolExecutor extends TThreadPoolExecutor implements ScheduledExecutorService {
    private final PriorityQueue<Task<?>> timers = new PriorityQueue<>();
    private Thread timer;
    private long seq;
    private final ThreadFactory tf;

    public TScheduledThreadPoolExecutor(int core) { this(core, Executors.defaultThreadFactory()); }
    public TScheduledThreadPoolExecutor(int core, ThreadFactory f) { super(core, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS, new LinkedBlockingQueue<>(), f); tf = f; }
    public TScheduledThreadPoolExecutor(int core, RejectedExecutionHandler h) { this(core, Executors.defaultThreadFactory()); }
    public TScheduledThreadPoolExecutor(int core, ThreadFactory f, RejectedExecutionHandler h) { this(core, f); }

    final class Task<V> extends FutureTask<V> implements RunnableScheduledFuture<V> {
        long time;
        final long period;
        final long order = seq++;
        Task(Callable<V> c, long time) { super(c); this.time = time; this.period = 0; }
        Task(Runnable r, long time, long period) { super(r, null); this.time = time; this.period = period; }
        public boolean isPeriodic() { return period != 0; }
        public long getDelay(TimeUnit unit) { return unit.convert(time - System.nanoTime(), TimeUnit.NANOSECONDS); }
        public int compareTo(Delayed o) {
            if (o instanceof Task) { Task<?> t = (Task<?>) o; int c = Long.compare(time, t.time); return c != 0 ? c : Long.compare(order, t.order); }
            return Long.compare(getDelay(TimeUnit.NANOSECONDS), o.getDelay(TimeUnit.NANOSECONDS));
        }
        @Override public void run() {
            if (!isPeriodic()) { super.run(); return; }
            if (runAndReset()) {
                time = period > 0 ? time + period : System.nanoTime() - period;
                enqueue(this);
            }
        }
    }

    private void enqueue(Task<?> t) {
        synchronized (timers) {
            if (isShutdown()) return;
            timers.add(t);
            if (timer == null) {
                timer = tf.newThread(this::timerLoop);
                timer.setDaemon(true);
                timer.start();
            }
            timers.notifyAll();
        }
    }

    private void timerLoop() {
        while (true) {
            Task<?> due;
            synchronized (timers) {
                while (true) {
                    if (isShutdown() && timers.isEmpty()) return;
                    Task<?> head = timers.peek();
                    long wait = head == null ? 0 : (head.time - System.nanoTime()) / 1000000L;
                    if (head != null && wait <= 0) { due = timers.poll(); break; }
                    try { timers.wait(head == null ? 0 : Math.max(1, wait)); } catch (InterruptedException e) { return; }
                }
            }
            if (!due.isCancelled()) execute(due);
        }
    }

    private static long trigger(long delay, TimeUnit unit) { return System.nanoTime() + unit.toNanos(Math.max(0, delay)); }

    public ScheduledFuture<?> schedule(Runnable r, long delay, TimeUnit unit) { Task<?> t = new Task<>(r, trigger(delay, unit), 0); enqueue(t); return t; }
    public <V> ScheduledFuture<V> schedule(Callable<V> c, long delay, TimeUnit unit) { Task<V> t = new Task<>(c, trigger(delay, unit)); enqueue(t); return t; }
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable r, long initial, long period, TimeUnit unit) {
        Task<?> t = new Task<>(r, trigger(initial, unit), unit.toNanos(period)); enqueue(t); return t;
    }
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable r, long initial, long delay, TimeUnit unit) {
        Task<?> t = new Task<>(r, trigger(initial, unit), -unit.toNanos(delay)); enqueue(t); return t;
    }
    @Override public void shutdown() { super.shutdown(); synchronized (timers) { timers.clear(); timers.notifyAll(); } }
    public void setRemoveOnCancelPolicy(boolean v) { }
    public void setContinueExistingPeriodicTasksAfterShutdownPolicy(boolean v) { }
    public void setExecuteExistingDelayedTasksAfterShutdownPolicy(boolean v) { }
}
