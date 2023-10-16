package ru.gb.seminar03.task03;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomIterator<T> implements Iterator<T>, Iterable<T> {
    private T[] array;
    private int index = 0; // Current position

    public CustomIterator(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return (index < array.length);
    }

    @Override
    public T next() {
        if(!hasNext()) {
            throw new NoSuchElementException("No next element.");
        }
       return array[index++];
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator<>(array);
    }
}
