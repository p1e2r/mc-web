package org.teavm.classlib.java.util.concurrent;
/** mc-web: CopyOnWriteArraySet backed by CopyOnWriteArrayList (MIT License). */
public class TCopyOnWriteArraySet<E> extends java.util.AbstractSet<E> implements java.io.Serializable {
    private final java.util.concurrent.CopyOnWriteArrayList<E> al;
    public TCopyOnWriteArraySet() { al = new java.util.concurrent.CopyOnWriteArrayList<>(); }
    public TCopyOnWriteArraySet(java.util.Collection<? extends E> c) { this(); addAll(c); }
    @Override public int size() { return al.size(); }
    @Override public boolean contains(Object o) { return al.contains(o); }
    @Override public boolean add(E e) { return al.addIfAbsent(e); }
    @Override public boolean remove(Object o) { return al.remove(o); }
    @Override public void clear() { al.clear(); }
    @Override public java.util.Iterator<E> iterator() { return al.iterator(); }
}
