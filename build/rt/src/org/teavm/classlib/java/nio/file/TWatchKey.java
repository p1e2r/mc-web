package org.teavm.classlib.java.nio.file;
/** mc-web (MIT License). */
public interface TWatchKey {
    boolean isValid();
    java.util.List<TWatchEvent<?>> pollEvents();
    boolean reset();
    void cancel();
    Object watchable();
}
