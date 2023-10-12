package ru.jdk.lecture03.ex08_wildcardSymbols;

public class Animal {
    protected String name;
    public Animal(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " with name " + name;
    }
}