package ru.gb.jdk.lecture02.samples.interfacesExample;

public interface Bull {
    public static final int amount = 4;
    default void walk() {
        System.out.println("Walks on " + amount + " hooves.");
    }
    void talk();
}
