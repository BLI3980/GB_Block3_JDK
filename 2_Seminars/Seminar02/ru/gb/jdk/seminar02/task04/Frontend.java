package ru.gb.jdk.seminar02.task04;

public interface Frontend {
    default void doesFront() {
        System.out.println("Does user interface part of programming");
    };
}
