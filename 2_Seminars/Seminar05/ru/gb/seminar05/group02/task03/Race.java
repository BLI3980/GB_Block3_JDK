package ru.gb.seminar05.group02.task03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Race extends Thread{
    private List<Runner> runners;
    private CountDownLatch cdl;

    public Race() {
        cdl = new CountDownLatch(3);
        runners = new ArrayList<>(3);
        runners.add(new Runner("Jummy1", cdl));
        runners.add(new Runner("Jummy2", cdl));
        runners.add(new Runner("Jummy3", cdl));
    }

    @Override
    public void run() {
        try {
            goToStart();
            cdl.await();
            readySteadyGo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void readySteadyGo() throws InterruptedException {
        sleep(1000);
        System.out.println("Ready!");
        sleep(1000);
        System.out.println("Steady!");
        sleep(1000);
        System.out.println("Go!");
        for (Runner runner : runners) {
            runner.go();
        }
    }

    private void goToStart() {
        for (Runner runner : runners) {
            runner.start();
        }
    }
}
