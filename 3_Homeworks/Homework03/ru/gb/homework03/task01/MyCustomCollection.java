package ru.gb.homework03.task01;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCustomCollection<T> {
    private Object[] array;
    private int currentSize;
    private final int DEFAULT_CAPACITY = 10;
    private MyIterator iterator;

    public MyCustomCollection() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.currentSize = 0;
        this.iterator = new MyIterator();
    }

    /**
     * Method for adding new element to the end of the array.
     * @param element - the element to add.
     */
    public void add(T element) {
        ensureCapacity(currentSize + 1);
        array[currentSize] = element;
        currentSize++;
    }

    /**
     * Method for removing the first occurrence of element from the array
     * @param element - element to remove
     */
    public void remove(T element) {
        Integer indexOfElementToRemove = find(element);
        if (indexOfElementToRemove != null) {
            // Option 1:
            System.arraycopy(array,indexOfElementToRemove +1,
                    array,indexOfElementToRemove, currentSize - indexOfElementToRemove - 1);
            currentSize--;
            array[currentSize] = null;

            // Option 2:
//            Object[] temp = new Object[array.length - 1];
//            for (int i = 0; i < indexOfElementToRemove; i++) {
//                temp[i] = array[i];
//            }
//            for (int j = indexOfElementToRemove; j < array.length - 1; j++) {
//                temp[j] = array[j + 1];
//            }
//            array = temp;
        }

    }

    /**
     * Method for removing element from the array by specifying its index
     * @param index - index of an element to delete
     */
//    public void remove(int index) {
//        if(index < 0 || index >= currentSize) {
//            throw new IndexOutOfBoundsException("Index is out of range.");
//        }
//        System.arraycopy(array, index + 1, array, index, currentSize - index - 1);
//        currentSize--;
//        array[currentSize] = null;
//    }

    /**
     * Method for finding the index of the first occurrence search element value of the array.
     * @param element - the value to find in the array
     * @return Returns null if no such element in the array
     */
    public Integer find(T element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) return i;
        }
        return null;
    }

    /**
     * Utility method for ensuring sufficient capacity of current array
     * @param minRequiredCapacity - minimum required capacity
     */
    private void ensureCapacity(int minRequiredCapacity) {
        int oldCapacity = array.length;
        if (minRequiredCapacity > oldCapacity) {
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (minRequiredCapacity > newCapacity) {
                newCapacity = minRequiredCapacity;
            }
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    /**
     * Method for converting the array to string
     * @return
     */
    public String info() {
        return Arrays.toString(array);
    }

    /**
     * Method for iterating through not null elements of the array
     */
    public void iterate() {
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (item != null) System.out.println(item);
        }
    }


    private class MyIterator implements Iterator<T>{
        private int index = 0; // Initial position in the array

        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next element.");
            } else {
                return (T) array[index++];
            }
        }
    }


}
