package org.teavm.classlib.java.nio.file;

/** mc-web: iterator over a path's name elements, backing the JDK's default Path.iterator() (MIT License). */
public final class TPathIter implements java.util.Iterator<TPath> {
    private final TPath path;
    private int index;

    public TPathIter(TPath path) { this.path = path; }

    @Override public boolean hasNext() { return index < path.getNameCount(); }

    @Override public TPath next() {
        if (!hasNext()) throw new java.util.NoSuchElementException();
        return path.getName(index++);
    }
}
