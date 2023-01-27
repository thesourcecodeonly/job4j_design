package ru.job4j.generics;

/**
 * Базовая модель объекта хранимого в контейнере.
 *
 * @author thesourcecodeonly (zv.specialone@gmail.com)
 * @version 0.1
 * @since 10.01.2023
 */
public abstract class Base {
    private final String id;
    public Base(final String id) {
        this.id = id;
    }

    /**
     * Возвращает идентификатор объекта.
     *
     * @return Уникальный идентификатор.
     */
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Base{" + "id='" + id + '\'' + '}';
    }
}