package ru.jdk.lecture03.ex05_upperLowerBounds;

import java.util.ArrayList;
import java.util.Arrays;

// Upper and lower wildcard bounds in generics
public class Main {
    public static void main(String[] args) {
        // Exhibit 1
//        System.out.println(compare(1, 1.0f));       // false
//        System.out.println(compare(1.0f, 1.0f));    // true
//        System.out.println(compare(1, 1));          // true

        // Exhibit 2
//        ArrayList<Integer> ial = new ArrayList<>(Arrays.asList(1, 2, 3));
//        ArrayList<Number> nal = new ArrayList<>(Arrays.asList(1f, 2, 3.0));
//        System.out.println(ial);
//        System.out.println(nal);
//        copyTo(ial, nal);
//        System.out.println(nal);
//        copyTo(nal, ial);
//        System.out.println(ial);

        //Exhibit 3
//        ArrayList<Animal> animals = new ArrayList<>(Arrays.asList(new Animal()));
//        ArrayList<Cat> cats = new ArrayList<>(Arrays.asList(new Cat()));
//        copyTo(animals, cats);
//        System.out.println(cats);
////        cats.get(1).voice();        // ClassCastException

        //Exhibit 4
        ArrayList<Animal> animals1 = new ArrayList<>(Arrays.asList(new Animal()));
        ArrayList<Cat> cats1 = new ArrayList<>(Arrays.asList(new Cat()));
//        copyTo(animals1, cats1);      // Compilation error.Cannot put parent type to child type
        System.out.println(cats1);
        cats1.get(1).voice();        // ClassCastException


    }

    private static <T extends Number> boolean compare(T src, T dst) {
        return src.equals(dst);
    }

//    private static void copyTo(ArrayList src, ArrayList dst) {
//        for (Object o : src) dst.add(o);
//    }

    private static <T> void copyTo(
            ArrayList<? extends T> src, ArrayList<? super T> dst) {
        for (T o : src) dst.add(o);
    }
}
