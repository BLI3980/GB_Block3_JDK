package ru.jdk.lecture03.ex06;

public class Box<T>{
    private T value;

    public Box() {
    }

    // Generic constructor
    <U> Box(U u){}

//    public Box(T value) {
//        this.value = value;
//    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void showType() {
        System.out.printf("Type is %s, with value %s\n",
                value.getClass().getName(), getValue());
    }
}
