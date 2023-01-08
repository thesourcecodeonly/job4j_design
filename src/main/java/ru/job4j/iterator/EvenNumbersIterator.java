package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] data;
    private int index = -1;
    private int evenIndex;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean has = false;
        for (int i = index + 1; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                has = true;
                evenIndex = i;
                break;
            }
        }
        return has;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if (hasNext()) {
            index = evenIndex;
            return data[index];
        }
        throw new NoSuchElementException();
    }
}
