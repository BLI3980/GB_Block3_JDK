package ru.gb.homework03.task01;

import java.util.Arrays;

public class MyArrayList<T> {

    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T element) {
        ensureCapacity(size + 1);
        array[size] = element;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        array[size] = null;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        return (T) array[index];
    }

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = array.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            array = Arrays.copyOf(array, newCapacity);
        }
    }
}
