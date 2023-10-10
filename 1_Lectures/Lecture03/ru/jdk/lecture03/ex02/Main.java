package ru.jdk.lecture03.ex02;

public class Main {
    public static void main(String[] args) {
        Gbox<String> stringBox = new Gbox<>("Hello!");
        stringBox.showType();
        Gbox<Integer> integerBox = new Gbox<>(12);
        integerBox.showType();
//        integerBox.setValue("World!"); // Compilation error
        Gbox Gb1 = new Gbox(20);   // Raw type

        // Generic methods
        Gbox<Integer> integerBox1 = new Gbox<>(null);
        setIfNull(integerBox1, 13);
        System.out.println(integerBox1.getValue());
        Gbox<Integer> integerBox2 = new Gbox<>(1);
        setIfNull(integerBox2, 13);
        System.out.println(integerBox2.getValue());
    }

    private static <T> void setIfNull(Gbox<T> box, T t) {
        if (box.getValue() == null) {
            box.setValue(t);
        }
    }
}
