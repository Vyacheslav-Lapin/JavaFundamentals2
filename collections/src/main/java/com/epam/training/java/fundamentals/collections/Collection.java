package com.epam.training.java.fundamentals.collections;

import com.epam.courses.jf.common.Private;
import com.sun.istack.internal.Nullable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.IntSupplier;
import java.util.stream.StreamSupport;

@FunctionalInterface
public interface Collection<E> extends java.util.Collection<E> {

    static <E> Collection<E> from(Iterable<E> iterable) {
        return iterable::iterator;
    }

    static <E> Collection<E> from(IntSupplier size, Iterable<E> iterable) {

        return new Collection<E>() {
            @Override
            public int size() {
                return size.getAsInt();
            }

            @Override
            public Iterator<E> iterator() {
                return iterable.iterator();
            }
        };
    }

    @Override
    default int size() {
        return (int) stream().count();
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>This implementation returns <tt>size() == 0</tt>.
     */
    @Override
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>This implementation iterates over the elements in the collection,
     * checking each element in turn for equality with the specified element.
     *
     * @throws ClassCastException   {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    default boolean contains(@Nullable Object o) {
        Iterator<E> it = iterator();
        if (o == null)
            while (it.hasNext())
                if (it.next() == null)
                    return true;
                else
                    while (it.hasNext())
                        if (o.equals(it.next()))
                            return true;
        return false;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>This implementation returns an array containing all the elements
     * returned by this collection's iterator, in the same order, stored in
     * consecutive elements of the array, starting with index {@code 0}.
     * The length of the returned array is equal to the number of elements
     * returned by the iterator, even if the size of this collection changes
     * during iteration, as might happen if the collection permits
     * concurrent modification during iteration.  The {@code size} method is
     * called only as an optimization hint; the correct result is returned
     * even if the iterator returns a different number of elements.
     * <p>
     * <p>This method is equivalent to:
     * <p>
     * <pre> {@code
     * List<E> list = new ArrayList<E>(size());
     * for (E e : this)
     *     list.add(e);
     * return list.toArray();
     * }</pre>
     */
    @Override
    default Object[] toArray() {
        // Estimate size of array; be prepared to see more or fewer elements
        Object[] r = new Object[size()];
        Iterator<E> it = iterator();
        for (int i = 0; i < r.length; i++) {
            if (!it.hasNext()) // fewer elements than expected
                return Arrays.copyOf(r, i);
            r[i] = it.next();
        }
        return it.hasNext() ? finishToArray(r, it) : r;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>This implementation returns an array containing all the elements
     * returned by this collection's iterator in the same order, stored in
     * consecutive elements of the array, starting with index {@code 0}.
     * If the number of elements returned by the iterator is too large to
     * fit into the specified array, then the elements are returned in a
     * newly allocated array with length equal to the number of elements
     * returned by the iterator, even if the size of this collection
     * changes during iteration, as might happen if the collection permits
     * concurrent modification during iteration.  The {@code size} method is
     * called only as an optimization hint; the correct result is returned
     * even if the iterator returns a different number of elements.
     * <p>
     * <p>This method is equivalent to:
     * <p>
     * <pre> {@code
     * List<E> list = new ArrayList<E>(size());
     * for (E e : this)
     *     list.add(e);
     * return list.toArray(a);
     * }</pre>
     *
     * @throws ArrayStoreException  {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    default <T> T[] toArray(T[] a) {
        // Estimate size of array; be prepared to see more or fewer elements
        int size = size();
        T[] r = a.length >= size ? a :
                (T[]) java.lang.reflect.Array
                        .newInstance(a.getClass().getComponentType(), size);
        Iterator<E> it = iterator();

        for (int i = 0; i < r.length; i++) {
            if (!it.hasNext()) { // fewer elements than expected
                if (a == r) {
                    r[i] = null; // null-terminate
                } else if (a.length < i) {
                    return Arrays.copyOf(r, i);
                } else {
                    System.arraycopy(r, 0, a, 0, i);
                    if (a.length > i) {
                        a[i] = null;
                    }
                }
                return a;
            }
            r[i] = (T) it.next();
        }
        // more elements than expected
        return it.hasNext() ? finishToArray(r, it) : r;
    }

    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
    int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * Reallocates the array being used within toArray when the iterator
     * returned more elements than expected, and finishes filling it from
     * the iterator.
     *
     * @param r  the array, replete with previously stored elements
     * @param it the in-progress iterator over this collection
     * @return array containing the elements in the given array, plus any
     * further elements returned by the iterator, trimmed to size
     */
    @SuppressWarnings("unchecked")
    @Private
    static <T> T[] finishToArray(T[] r, Iterator<?> it) {
        int i = r.length;
        while (it.hasNext()) {
            int cap = r.length;
            if (i == cap) {
                int newCap = cap + (cap >> 1) + 1;
                // overflow-conscious code
                if (newCap - MAX_ARRAY_SIZE > 0)
                    newCap = hugeCapacity(cap + 1);
                r = Arrays.copyOf(r, newCap);
            }
            r[i++] = (T) it.next();
        }
        // trim if overallocated
        return (i == r.length) ? r : Arrays.copyOf(r, i);
    }

    @Private
    static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError("Required array size too large");
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    // Modification Operations

    /**
     * {@inheritDoc}
     * <p>
     * <p>This implementation always throws an
     * <tt>UnsupportedOperationException</tt>.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IllegalStateException         {@inheritDoc}
     */
    @Override
    default boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>This implementation iterates over the collection looking for the
     * specified element.  If it finds the element, it removes the element
     * from the collection using the iterator's remove method.
     * <p>
     * <p>Note that this implementation throws an
     * <tt>UnsupportedOperationException</tt> if the iterator returned by this
     * collection's iterator method does not implement the <tt>remove</tt>
     * method and this collection contains the specified object.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     */
    @Override
    default boolean remove(Object o) {
        Iterator<E> it = iterator();
        if (o == null)
            while (it.hasNext())
                if (it.next() == null) {
                    it.remove();
                    return true;
                } else
                    while (it.hasNext())
                        if (o.equals(it.next())) {
                            it.remove();
                            return true;
                        }
        return false;
    }

    // Bulk Operations

    /**
     * {@inheritDoc}
     * <p>
     * <p>This implementation iterates over the specified collection,
     * checking each element returned by the iterator in turn to see
     * if it's contained in this collection.  If all elements are so
     * contained <tt>true</tt> is returned, otherwise <tt>false</tt>.
     *
     * @throws ClassCastException   {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @see #contains(Object)
     */
    @Override
    default boolean containsAll(java.util.Collection<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>This implementation iterates over the specified collection, and adds
     * each object returned by the iterator to this collection, in turn.
     * <p>
     * <p>Note that this implementation will throw an
     * <tt>UnsupportedOperationException</tt> unless <tt>add</tt> is
     * overridden (assuming the specified collection is non-empty).
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IllegalStateException         {@inheritDoc}
     * @see #add(Object)
     */
    @Override
    default boolean addAll(java.util.Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c)
            if (add(e))
                modified = true;
        return modified;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>This implementation iterates over this collection, checking each
     * element returned by the iterator in turn to see if it's contained
     * in the specified collection.  If it's so contained, it's removed from
     * this collection with the iterator's <tt>remove</tt> method.
     * <p>
     * <p>Note that this implementation will throw an
     * <tt>UnsupportedOperationException</tt> if the iterator returned by the
     * <tt>iterator</tt> method does not implement the <tt>remove</tt> method
     * and this collection contains one or more elements in common with the
     * specified collection.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @see #remove(Object)
     * @see #contains(Object)
     */
    @Override
    default boolean removeAll(java.util.Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<?> it = iterator();
        while (it.hasNext()) {
            if (c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>This implementation iterates over this collection, checking each
     * element returned by the iterator in turn to see if it's contained
     * in the specified collection.  If it's not so contained, it's removed
     * from this collection with the iterator's <tt>remove</tt> method.
     * <p>
     * <p>Note that this implementation will throw an
     * <tt>UnsupportedOperationException</tt> if the iterator returned by the
     * <tt>iterator</tt> method does not implement the <tt>remove</tt> method
     * and this collection contains one or more elements not present in the
     * specified collection.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @see #remove(Object)
     * @see #contains(Object)
     */
    @Override
    default boolean retainAll(java.util.Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>This implementation iterates over this collection, removing each
     * element using the <tt>Iterator.remove</tt> operation.  Most
     * implementations will probably choose to override this method for
     * efficiency.
     * <p>
     * <p>Note that this implementation will throw an
     * <tt>UnsupportedOperationException</tt> if the iterator returned by this
     * collection's <tt>iterator</tt> method does not implement the
     * <tt>remove</tt> method and this collection is non-empty.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     */
    @Override
    default void clear() {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }
}
