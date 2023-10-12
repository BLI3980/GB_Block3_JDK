package ru.jdk.lecture03.task01;

import java.util.Arrays;

// Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
public class Main {
    public static void main(String[] args) {
        String[] str = new String[]{"abc", "cba"};
        System.out.println(Arrays.toString(str));
        Integer[] int1 = {1, 2, 3};
        System.out.println(Arrays.toString(int1));
        Integer[] int2 = {1};
        System.out.println(Arrays.toString(int2));

        swap(str);
        System.out.println(Arrays.toString(str));
        swap(int1);
        System.out.println(Arrays.toString(int1));
        swap(int2);
        System.out.println(Arrays.toString(int2));

    }

    private static <T> void swap(T[] array) {
        if (array.length<= 1) return;
        T temp = array[1];
        array[1] = array[0];
        array[0] = temp;
    }
}
