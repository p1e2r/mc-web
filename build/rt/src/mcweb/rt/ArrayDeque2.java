package mcweb.rt;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * mc-web: circular-buffer Deque standing in for java.util.ArrayDeque, whose TeaVM version corrupts the deque when
 * Iterator.remove() is used (MIT License).
 */
@SuppressWarnings("unchecked")
public class ArrayDeque2<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, java.io.Serializable {
    private Object[] a;
    private int head;
    private int size;
    private int modCount;

    public ArrayDeque2() { a = new Object[16]; }
    public ArrayDeque2(int n) { a = new Object[Math.max(4, n + 1)]; }
    public ArrayDeque2(Collection<? extends E> c) { this(c.size()); addAll(c); }

    private int idx(int i) { int j = head + i; return j >= a.length ? j - a.length : j; }

    private void grow() {
        Object[] b = new Object[a.length * 2];
        for (int i = 0; i < size; i++) b[i] = a[idx(i)];
        a = b;
        head = 0;
    }

    private static void nn(Object e) { if (e == null) throw new NullPointerException(); }

    @Override public void addFirst(E e) {
        nn(e);
        if (size == a.length) grow();
        head = head == 0 ? a.length - 1 : head - 1;
        a[head] = e;
        size++;
        modCount++;
    }

    @Override public void addLast(E e) {
        nn(e);
        if (size == a.length) grow();
        a[idx(size)] = e;
        size++;
        modCount++;
    }

    @Override public boolean offerFirst(E e) { addFirst(e); return true; }
    @Override public boolean offerLast(E e) { addLast(e); return true; }

    @Override public E pollFirst() {
        if (size == 0) return null;
        E e = (E) a[head];
        a[head] = null;
        head = idx(1);
        size--;
        modCount++;
        return e;
    }

    @Override public E pollLast() {
        if (size == 0) return null;
        int t = idx(size - 1);
        E e = (E) a[t];
        a[t] = null;
        size--;
        modCount++;
        return e;
    }

    @Override public E removeFirst() { E e = pollFirst(); if (e == null) throw new NoSuchElementException(); return e; }
    @Override public E removeLast() { E e = pollLast(); if (e == null) throw new NoSuchElementException(); return e; }
    @Override public E peekFirst() { return size == 0 ? null : (E) a[head]; }
    @Override public E peekLast() { return size == 0 ? null : (E) a[idx(size - 1)]; }
    @Override public E getFirst() { if (size == 0) throw new NoSuchElementException(); return (E) a[head]; }
    @Override public E getLast() { if (size == 0) throw new NoSuchElementException(); return (E) a[idx(size - 1)]; }

    /** removes the element at logical position i, shifting the tail left. */
    private void removeAt(int i) {
        for (int k = i; k < size - 1; k++) a[idx(k)] = a[idx(k + 1)];
        a[idx(size - 1)] = null;
        size--;
        modCount++;
    }

    @Override public boolean removeFirstOccurrence(Object o) {
        if (o == null) return false;
        for (int i = 0; i < size; i++) if (o.equals(a[idx(i)])) { removeAt(i); return true; }
        return false;
    }

    @Override public boolean removeLastOccurrence(Object o) {
        if (o == null) return false;
        for (int i = size - 1; i >= 0; i--) if (o.equals(a[idx(i)])) { removeAt(i); return true; }
        return false;
    }

    @Override public boolean add(E e) { addLast(e); return true; }
    @Override public boolean offer(E e) { addLast(e); return true; }
    @Override public E remove() { return removeFirst(); }
    @Override public E poll() { return pollFirst(); }
    @Override public E element() { return getFirst(); }
    @Override public E peek() { return peekFirst(); }
    @Override public void push(E e) { addFirst(e); }
    @Override public E pop() { return removeFirst(); }
    @Override public boolean remove(Object o) { return removeFirstOccurrence(o); }
    @Override public int size() { return size; }
    @Override public boolean isEmpty() { return size == 0; }

    @Override public boolean contains(Object o) {
        if (o == null) return false;
        for (int i = 0; i < size; i++) if (o.equals(a[idx(i)])) return true;
        return false;
    }

    @Override public void clear() {
        for (int i = 0; i < size; i++) a[idx(i)] = null;
        head = 0;
        size = 0;
        modCount++;
    }

    @Override public boolean removeIf(Predicate<? super E> filter) {
        int w = 0;
        boolean any = false;
        for (int r = 0; r < size; r++) {
            Object e = a[idx(r)];
            if (filter.test((E) e)) { any = true; continue; }
            a[idx(w++)] = e;
        }
        for (int k = w; k < size; k++) a[idx(k)] = null;
        if (any) { size = w; modCount++; }
        return any;
    }

    @Override public void forEach(Consumer<? super E> action) {
        int mc = modCount;
        for (int i = 0; i < size; i++) {
            action.accept((E) a[idx(i)]);
            if (mc != modCount) throw new ConcurrentModificationException();
        }
    }

    @Override public Object[] toArray() {
        Object[] r = new Object[size];
        for (int i = 0; i < size; i++) r[i] = a[idx(i)];
        return r;
    }

    @Override public <T> T[] toArray(T[] r) {
        if (r.length < size) r = (T[]) java.lang.reflect.Array.newInstance(r.getClass().getComponentType(), size);
        for (int i = 0; i < size; i++) r[i] = (T) a[idx(i)];
        if (r.length > size) r[size] = null;
        return r;
    }

    @Override public Iterator<E> iterator() {
        return new Iterator<E>() {
            int next = 0;
            int last = -1;
            int expected = modCount;

            @Override public boolean hasNext() { return next < size; }

            @Override public E next() {
                if (expected != modCount) throw new ConcurrentModificationException();
                if (next >= size) throw new NoSuchElementException();
                last = next++;
                return (E) a[idx(last)];
            }

            @Override public void remove() {
                if (last < 0) throw new IllegalStateException();
                if (expected != modCount) throw new ConcurrentModificationException();
                removeAt(last);
                next = last;
                last = -1;
                expected = modCount;
            }
        };
    }

    @Override public Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            int next = size - 1;
            int last = -1;
            int expected = modCount;

            @Override public boolean hasNext() { return next >= 0; }

            @Override public E next() {
                if (expected != modCount) throw new ConcurrentModificationException();
                if (next < 0) throw new NoSuchElementException();
                last = next--;
                return (E) a[idx(last)];
            }

            @Override public void remove() {
                if (last < 0) throw new IllegalStateException();
                if (expected != modCount) throw new ConcurrentModificationException();
                removeAt(last);
                last = -1;
                expected = modCount;
            }
        };
    }

    @Override public ArrayDeque2<E> clone() {
        ArrayDeque2<E> c = new ArrayDeque2<>(size);
        for (int i = 0; i < size; i++) c.addLast((E) a[idx(i)]);
        return c;
    }

    @Override public Deque<E> reversed() {
        ArrayDeque2<E> c = new ArrayDeque2<>(size);
        for (int i = size - 1; i >= 0; i--) c.addLast((E) a[idx(i)]);
        return c;
    }
}
