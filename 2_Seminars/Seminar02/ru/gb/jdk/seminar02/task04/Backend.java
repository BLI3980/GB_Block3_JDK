package ru.gb.jdk.seminar02.task04;

public interface Backend {
    default void doesBack() {
        System.out.println("Does server part of programming");
    };
}
