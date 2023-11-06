package ru.gb.seminar05.group01.task02.groupVersion;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicBoolean switcher = new AtomicBoolean();
        AtomicInteger count = new AtomicInteger(100);
        Object x = new Object();

        Thread threadA = new Thread(() -> {
            while (count.get() > 0) {
                switcher.set(!switcher.get());
                System.out.println("\nThread A msg: Switcher is - " + switcher.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            while (count.get() > 0) {
                if (switcher.get()) {
                    System.out.print(count.get() + " ");
                    count.set(count.get() - 1);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadA.start();
        threadB.start();

    }

}
