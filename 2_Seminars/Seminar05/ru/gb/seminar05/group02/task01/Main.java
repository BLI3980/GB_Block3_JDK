package ru.gb.seminar05.group02.task01;

/**
 * Deadlock example: Need to create two classes. Implement a situation when two threads will be deadlocked for
 * objects of those two classes
 */
public class Main {
    public static void main(String[] args) {
        Friend friend1 = new Friend("Jimmy 1");
        Friend friend2 = new Friend("Jimmy 2");

        MyThread myThread1 = new MyThread(friend1, friend2);
        MyThread myThread2 = new MyThread(friend2, friend1);

        // Deadlock will happen in bowBack() method of each thread
        myThread1.start();
        myThread2.start();

    }
}
