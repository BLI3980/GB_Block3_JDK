package ru.jdk.lecture03.ex03_boundedParamTypes;

public class BBox<V extends Number>{
    private V value;
    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }
}
