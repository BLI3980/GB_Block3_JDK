package ru.gb.seminar05.group01.task03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    // 0 - not ready; 1 - ready to run; 2 - run; 3 - finished.
    public static AtomicInteger runnerAState = new AtomicInteger(0);
    public static AtomicInteger runnerBState = new AtomicInteger(0);
    public static AtomicInteger runnerCState = new AtomicInteger(0);
    public static Random random = new Random();

    public static void main(String[] args) {
        Thread runnerA = new Thread(() -> {
            try {
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))
                        + ": " + Thread.currentThread().getName() + " is preparing for start.");
                Thread.sleep(random.nextInt(1000, 5000));
                runnerAState.set(1);
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))
                        + ": " + Thread.currentThread().getName() + " is ready.");
                while (runnerAState.get() != 2) {
                    Thread.sleep(2);
                }
                Thread.sleep(random.nextInt(1000, 5000));
                runnerAState.set(3);
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))
                        + ": " + Thread.currentThread().getName() + " has finished the race.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        Thread runnerB = new Thread(() -> {
            try {
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))
                        + ": " + Thread.currentThread().getName() + " is preparing for start.");
                Thread.sleep(random.nextInt(1000, 5000));
                runnerBState.set(1);
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))
                        + ": " + Thread.currentThread().getName() + " is ready.");
                while (runnerBState.get() != 2) {
                    Thread.sleep(2);
                }
                Thread.sleep(random.nextInt(1000, 5000));
                runnerBState.set(3);
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))
                        + ": " + Thread.currentThread().getName() + " has finished the race.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread runnerC = new Thread(() -> {
            try {
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))
                        + ": " + Thread.currentThread().getName() + " is preparing for start.");
                Thread.sleep(random.nextInt(1000, 5000));
                runnerCState.set(1);
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))
                        + ": " + Thread.currentThread().getName() + " is ready.");
                while (runnerCState.get() != 2) {
                    Thread.sleep(2);
                }
                Thread.sleep(random.nextInt(1000, 5000));
                runnerCState.set(3);
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))
                        + ": " + Thread.currentThread().getName() + " has finished the race.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread judge = new Thread(() -> {
            runnerA.start();
            runnerB.start();
            runnerC.start();

            while (!isFinished()) {
                if (isReady()) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("Ready!");
                        Thread.sleep(1000);
                        System.out.println("Steady!");
                        Thread.sleep(1000);
                        System.out.println("Go!");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    runnerAState.set(2);
                    runnerBState.set(2);
                    runnerCState.set(2);
                    System.out.println("The race has started.");
                }
            }
            try {
                Thread.sleep(100);
                System.out.println("The race is complete! ");
                runnerA.interrupt();
                runnerB.interrupt();
                runnerC.interrupt();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        judge.start();


    }
    private static boolean isFinished() {
        return (runnerAState.get() == 3 && runnerBState.get() == 3 && runnerCState.get() == 3);
    }

    private static boolean isReady() {
        return (runnerAState.get() == 1 && runnerBState.get() == 1 && runnerCState.get() == 1);
    }

}
