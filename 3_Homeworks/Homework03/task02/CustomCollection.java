package task02;

import java.util.Arrays;

public class CustomCollection<T> {
    private Object[] array;
    private int currentSize;
    private final int DEFAULT_CAPACITY = 10;

    public CustomCollection() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.currentSize = 0;
    }

    public void add(T t) {
        ensureCapacity(currentSize + 1);
        array[currentSize] = t;
        currentSize++;
//        Object[] temp = new Object[array.length + 1];
//        for (int i = 0; i < array.length; i++) {
//            temp[i] = array[i];
//        }
//        temp[temp.length - 1] = t;
//        array = temp;

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
     * @param index
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
     * @param element
     * @return Returns null if no such element in the array
     */
    public Integer find(T element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) return i;
        }
        return null;
    }

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

    public String info() {
        return Arrays.toString(array);
    }


}
