package ru.jdk.lecture03.ex09_captureOf;

// Capture of ?
public class Main {
    public static void main(String[] args) {

    }
    // Problem
    static void testError(Tbox<?> box) {
//        box.setValue(box.getValue());       // "Capture of ?" compilation error
    }

    // Solution
    private static <T> void testErrorHelper(Tbox<T> box) {
        box.setValue(box.getValue());
    }

    static void testError1(Tbox<?> box) {
        testErrorHelper(box);              // No capture error
    }

}
