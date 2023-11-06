package ru.gb.seminar05.group01.task02.myVersion;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadB extends Thread{
    private AtomicBoolean switcher;
    private AtomicInteger count;

    public ThreadB(AtomicBoolean switcher) {
        this.switcher = switcher;
        count = new AtomicInteger(100);
    }

    public AtomicInteger getCount() {
        return count;
    }

    public void setCount(AtomicInteger count) {
        this.count = count;
    }

    @Override
    public void run() {
        try {
            countDown(switcher);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void countDown(AtomicBoolean switcher) throws InterruptedException {
        while (count.get() > 0) {
            if (switcher.get()) {
                count.set(count.decrementAndGet());
                System.out.println(count.get());
                sleep(100);
            }
        }
    }



}
