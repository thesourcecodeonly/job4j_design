package ru.job4j.collection;

import java.util.NoSuchElementException;

/**
 * <h2>Очередь на двух стеках [#438883]</h2>
 * Реализовать класс {@code SimpleQueue} - это очередь
 * FIFO - First Input First Output. Очередь реализованна на базе двух стеков.
 * <ul>
 * <li>Метод {@code T poll()} - должен возвращать первое значение
 * и удалять его из коллекции.</li>
 * <li>Метод {@code push(T value)} - помещает значение в конец.</li>
 * </ul>
 *
 * @author VyacheslavZhigalov
 * @version 0.1
 * @since 04.04.2023
 */
public class SimpleQueue<T> {
    SimpleStack<T> in = new SimpleStack<>();
    SimpleStack<T> out = new SimpleStack<>();

    /**
     * Метод должен возвращать первое значение и удалять его из коллекции.
     *
     * @return Первое значение.
     */
    public T poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     * Метод проверяет очередь на пустоту.
     *
     * @return возвращает true если очередь пуста, иначе false.
     */
    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    /**
     * Метод помещает значение в конец очереди.
     *
     * @param value Помещаемое значение в очередь.
     */
    public void push(T value) {
        in.push(value);
    }
}