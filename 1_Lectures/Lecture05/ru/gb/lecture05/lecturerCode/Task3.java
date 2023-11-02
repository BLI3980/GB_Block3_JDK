package ru.gb.lecture05.lecturerCode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Task3 implements Runnable{
    private final AtomicInteger value;
    private CountDownLatch cdl;

    public Task3(int value) {
        this.value = new AtomicInteger(value);
    }

    // Can use either this signature:
    public void increment() {
        value.incrementAndGet();
    }

    // Or this;
//    public void increment() {
//        synchronized (Task2.class) {
//            value++;
//        }
//    }

    public int getValue() {
        return value.intValue();
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
