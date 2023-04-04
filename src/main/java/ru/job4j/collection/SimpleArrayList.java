package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {
    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
            container = grow();
        }
        container[size++] = value;
        modCount++;
    }

    public  T[] grow() {
        int newCapacity = (int) (container.length * 2);
        return Arrays.copyOf(container, newCapacity);
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        T tmp = container[index];
        container[index] = newValue;
        return tmp;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T oldValue = container[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(container, index + 1, container, index,
                             numMoved);
        }
        container[--size] = null;
        modCount++;
        return oldValue;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int pointer = 0;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return pointer < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[pointer++];
            }
        };
    }
}