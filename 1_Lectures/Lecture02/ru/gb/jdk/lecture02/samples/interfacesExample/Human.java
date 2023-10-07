package ru.gb.jdk.lecture02.samples.interfacesExample;

public interface Human {
    default void walk() {
        System.out.println("Walks on feet.");
    }
    void talk();
}
