package org.teavm.classlib.java.nio.file;
/** mc-web (MIT License). */
public interface TWatchService extends java.io.Closeable {
    TWatchKey poll();
    TWatchKey poll(long timeout, java.util.concurrent.TimeUnit unit) throws InterruptedException;
    TWatchKey take() throws InterruptedException;
}
