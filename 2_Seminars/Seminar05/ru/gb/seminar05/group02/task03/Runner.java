package ru.gb.seminar05.group02.task03;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner extends Thread{
    private String name;
    private double speed;
    private Random random;
    private CountDownLatch cdl;

    public Runner(String name, CountDownLatch cdl) {
        this.name = name;
        this.cdl = cdl;
        random = new Random();
        speed = random.nextDouble(2, 7);
    }

    @Override
    public void run() {
        try {
            goToStart();
            synchronized (this) {
                wait();
            }
            raceToFinish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void goToStart() throws InterruptedException {
        System.out.println(name + " goes to start.");
        sleep(random.nextInt(2, 5) * 1000L);
        System.out.println(name + " is on start position. ");
        cdl.countDown();
    }

    private void raceToFinish() throws InterruptedException {
        sleep((long)(speed * 1000L));
        System.out.println(name + " has finished the race. ");
    }

    public void go() {
        synchronized (this) {
            notify();
        }
    }
}
