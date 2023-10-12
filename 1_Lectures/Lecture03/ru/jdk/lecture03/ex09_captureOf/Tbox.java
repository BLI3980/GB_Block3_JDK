package ru.jdk.lecture03.ex09_captureOf;

public class Tbox<T> {
    public static final Tbox EMPTY_BOX = new Tbox<>();
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    static <T> Tbox<T> emptyBox() {
        return (Tbox<T>) EMPTY_BOX;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
