package ru.jdk.lecture03.ex03;

// Bounded parameter types
public class Main {
    public static void main(String[] args) {
        BBox<Integer> integerBox = new BBox<>();
//        BBox<String> stringBox = new BBox<>();      // String does not extend Number

        setIfNull(integerBox, 4);
//        setIfNull(stringBox, "Hello");           // String does not extend Number
    }

    private static <T extends Number> void setIfNull(BBox<T> box, T t) {
        if (box.getValue() == null) {
            box.setValue(t);
        }
    }
}
