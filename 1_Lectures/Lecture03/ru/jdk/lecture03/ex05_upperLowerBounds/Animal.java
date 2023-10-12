package ru.jdk.lecture03.ex05_upperLowerBounds;

public class Animal {
    protected String name;

    protected Animal() {
        this.name = "Animal";
    }

    @Override
    public String toString() {
        return name;
    }
}
