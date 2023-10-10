package ru.gb.jdk.seminar02.task03;

public interface Backend {
    default void doesBack() {
        System.out.println("Does server part of programming");
    };
}
