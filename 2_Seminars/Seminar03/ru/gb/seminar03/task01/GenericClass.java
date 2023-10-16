package ru.gb.seminar03.task01;

import java.io.InputStream;
import java.io.Serializable;

public class GenericClass<T extends Comparable, V extends InputStream & Serializable, K extends Number> {
    private T field1;
    private V field2;
    private K field3;

    public GenericClass(T field1, V field2, K field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public T getField1() {
        return field1;
    }

    public V getField2() {
        return field2;
    }

    public K getField3() {
        return field3;
    }

    public String getFieldsClasses() {
        return String.format("T - type of %s, V - type of %s, K - type of %s",
                getField1().getClass().getSimpleName(),
                getField2().getClass().getSimpleName(),
                getField3().getClass().getSimpleName());
    }


}
