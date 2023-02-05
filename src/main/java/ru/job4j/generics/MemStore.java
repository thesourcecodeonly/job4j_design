package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Каркас универсального хранилища
 *
 * @author Vyacheslav Zhigalov
 * @version 0.1
 * @since 5.02.23
 */
public final class MemStore<T extends Base> implements Store<T> {
    private final Map<String, T> storage = new HashMap<>();

    /**
    * Добавить элемент в хранилище.
    *
    * @param model Добавляемый элемент.
    */
    @Override
    public void add(T model) {
        storage.putIfAbsent(model.getId(), model);
    }

    /**
     * Заменить элемент в хранилище по идентификатору
     *
     * @param id идентификатор элемента
     * @param model новый элемент
     * @return true -  в случае удачной замены, иначе - false
     */

    @Override
    public boolean replace(String id, T model) {
        return storage.replace(id, storage.get(id), model);
    }

    /**
     * Удаление элемента из хранилища
     *
     * @param id идентификатор элемента
     * @return true -  в случае удачной удаления, иначе - false
     */
    @Override
    public boolean delete(String id) {
        return storage.remove(id, storage.get(id));
    }

    /**
     * Поиск элемента по идентификатору
     *
     * @param id идентификатор элемента
     * @return найденный элемент
     */
    @Override
    public T findById(String id) {
        return storage.get(id);
    }
}
