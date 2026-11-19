package org.teavm.classlib.java.util.concurrent;

import java.util.Collection;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/** mc-web: sequential ForkJoinTask (MIT License). fork() runs the task immediately; join() returns its result. */
public abstract class TForkJoinTask<V> implements Future<V>, java.io.Serializable {
    private static final int NEW = 0, DONE = 1, FAILED = 2, CANCELLED = 3;
    private int state;
    private Throwable failure;

    public abstract V getRawResult();
    protected abstract void setRawResult(V value);
    protected abstract boolean exec();

    private void run() {
        if (state != NEW) return;
        try {
            if (exec()) state = DONE;
            else state = DONE;
        } catch (Throwable t) {
            failure = t;
            state = FAILED;
        }
    }

    private V report() {
        if (state == CANCELLED) throw new CancellationException();
        if (state == FAILED) {
            if (failure instanceof RuntimeException) throw (RuntimeException) failure;
            if (failure instanceof Error) throw (Error) failure;
            throw new RuntimeException(failure);
        }
        return getRawResult();
    }

    public final TForkJoinTask<V> fork() { run(); return this; }
    public final V join() { run(); return report(); }
    public final V invoke() { run(); return report(); }
    public final void quietlyJoin() { run(); }
    public final void quietlyInvoke() { run(); }
    public final void quietlyComplete() { state = DONE; }

    public static void invokeAll(TForkJoinTask<?> t1, TForkJoinTask<?> t2) { t1.invoke(); t2.invoke(); }
    public static void invokeAll(TForkJoinTask<?>... tasks) { for (TForkJoinTask<?> t : tasks) t.invoke(); }
    public static <T extends TForkJoinTask<?>> Collection<T> invokeAll(Collection<T> tasks) { for (T t : tasks) t.invoke(); return tasks; }

    public boolean cancel(boolean mayInterrupt) { if (state == NEW) state = CANCELLED; return state == CANCELLED; }
    public final boolean isDone() { return state != NEW; }
    public final boolean isCancelled() { return state == CANCELLED; }
    public final boolean isCompletedAbnormally() { return state == FAILED || state == CANCELLED; }
    public final boolean isCompletedNormally() { return state == DONE; }
    public final Throwable getException() { return state == CANCELLED ? new CancellationException() : failure; }
    public void completeExceptionally(Throwable ex) { failure = ex; state = FAILED; }
    public void complete(V value) { setRawResult(value); state = DONE; }
    public void reinitialize() { state = NEW; failure = null; }
    private short tag;
    public final short getForkJoinTaskTag() { return tag; }
    public final short setForkJoinTaskTag(short t) { short o = tag; tag = t; return o; }
    public final boolean compareAndSetForkJoinTaskTag(short e, short t) { if (tag != e) return false; tag = t; return true; }
    public boolean tryUnfork() { return false; }

    public final V get() throws InterruptedException, ExecutionException {
        run();
        if (state == CANCELLED) throw new CancellationException();
        if (state == FAILED) throw new ExecutionException(failure);
        return getRawResult();
    }
    public final V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException { return get(); }

    public static ForkJoinPool getPool() { return ForkJoinPool.commonPool(); }
    public static boolean inForkJoinPool() { return false; }
    public static void helpQuiesce() { }
    public static int getQueuedTaskCount() { return 0; }
    public static int getSurplusQueuedTaskCount() { return 0; }

    public static <T> TForkJoinTask<T> adapt(Runnable r, T result) { return new Adapted<>(() -> { r.run(); return result; }); }
    public static TForkJoinTask<?> adapt(Runnable r) { return new Adapted<>(() -> { r.run(); return null; }); }
    public static <T> TForkJoinTask<T> adapt(java.util.concurrent.Callable<? extends T> c) { return new Adapted<>(c); }

    static final class Adapted<T> extends TForkJoinTask<T> {
        final java.util.concurrent.Callable<? extends T> c;
        T result;
        Adapted(java.util.concurrent.Callable<? extends T> c) { this.c = c; }
        public T getRawResult() { return result; }
        protected void setRawResult(T v) { result = v; }
        protected boolean exec() {
            try { result = c.call(); } catch (RuntimeException e) { throw e; } catch (Exception e) { throw new RuntimeException(e); }
            return true;
        }
    }
}
