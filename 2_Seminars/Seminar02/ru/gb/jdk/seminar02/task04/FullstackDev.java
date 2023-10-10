package ru.gb.jdk.seminar02.task04;


public class FullstackDev extends Developer implements Backend, Frontend {

    void doesBoth() {
        System.out.println("Can do both backend and frontend");
    }

}

