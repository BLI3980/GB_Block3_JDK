package ru.jdk.lecture03.ex02_genericClassesAndMethods;

public class Gbox<T>{
    private T value;

    public Gbox(T value) {
        this.value = value;
    }

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
