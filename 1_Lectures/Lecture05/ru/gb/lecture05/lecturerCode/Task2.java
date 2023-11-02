package ru.gb.lecture05.lecturerCode;

import java.util.concurrent.CountDownLatch;

public class Task2 implements Runnable{
    private int value;
    private CountDownLatch cdl;

    public Task2(int value) {
        this.value = value;
    }

    // Can use either this signature:
    public synchronized void increment() {
        value++;
    }

    // Or this;
//    public void increment() {
//        synchronized (Task2.class) {
//            value++;
//        }
//    }

    public int getValue() {
        return value;
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000_000; i++) {
            increment();
        }
        cdl.countDown();
    }

    @Override
    public String toString() {
        return String.format("(%s)", value);
    }
}
