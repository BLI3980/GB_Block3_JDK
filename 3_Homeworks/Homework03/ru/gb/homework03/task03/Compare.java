package ru.gb.homework03.task03;

public class Compare {
    public static <T> boolean compareArrays(T[] array1, T[] array2) {
        checkIfAcceptable(array1, array2);
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }
        return true;
    }

    private static  <T> void checkIfAcceptable(T[] array1, T[] array2) {
        if(array1.length !=array2.length ) {
            throw new RuntimeException("Arrays must have equal size.");
        }
        if(!array1.getClass().equals(array2.getClass())){
            throw new RuntimeException("Arrays must be of same type");
        }
    }
}
