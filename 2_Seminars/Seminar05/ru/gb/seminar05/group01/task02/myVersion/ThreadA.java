package ru.gb.seminar05.group01.task02.myVersion;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadA extends Thread{
    private AtomicBoolean switcher;
    private AtomicInteger count;

    public ThreadA() {
        this.switcher = new AtomicBoolean(false);
    }

    public AtomicBoolean getSwitcher() {
        return switcher;
    }

    public void setSwitcher(AtomicBoolean switcher) {
        this.switcher = switcher;
    }

    public AtomicInteger getCount() {
        return count;
    }

    public void setCount(AtomicInteger count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (count.get() > 0) {
            try {
                sleep(1000);
                if (switcher.get()) switcher.set(false);
                else switcher.set(true);
                System.out.println(switcher);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
