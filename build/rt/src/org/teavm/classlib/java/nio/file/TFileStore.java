package org.teavm.classlib.java.nio.file;
/** mc-web (MIT License). */
public abstract class TFileStore {
    protected TFileStore() { }
    public abstract String name();
    public abstract String type();
    public abstract boolean isReadOnly();
    public abstract long getTotalSpace() throws java.io.IOException;
    public abstract long getUsableSpace() throws java.io.IOException;
    public abstract long getUnallocatedSpace() throws java.io.IOException;
    public long getBlockSize() throws java.io.IOException { return 4096; }
    public abstract boolean supportsFileAttributeView(Class<?> type);
    public abstract boolean supportsFileAttributeView(String name);
    public abstract <V> V getFileStoreAttributeView(Class<V> type);
    public abstract Object getAttribute(String attribute) throws java.io.IOException;
}
