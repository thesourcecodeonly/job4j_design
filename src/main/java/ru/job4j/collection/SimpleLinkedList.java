package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements LinkedList<E> {
    private int size;
    private int modCount;
    private Node<E> head;
    private Node<E> tail;

    public boolean isEmpty() {
        return head == null;
    }
    @Override
    public void add(E value) {
        Node<E> node = new Node<>(value, null);
        if (isEmpty()) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        modCount++;
        size++;

    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                break;
            }
            current = current.next;
        }
        return current.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> pointer = head;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {

                return pointer != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = pointer.item;
                pointer = pointer.next;
                return value;
            }
        };
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
