package ru.gb.jdk.seminar02.task03;

public interface Frontend {
    default void doesFront() {
        System.out.println("Does user interface part of programming");
    };
}
