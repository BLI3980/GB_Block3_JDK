package ru.gb.seminar05.group01.task01.version02;

/**
 * Создать два класс ObjectA, ObjectB
 * Реализовать класс в котором два потока вызовут DeadLock
 */
public class Version02 {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        DeadLockOne deadLockOne = new DeadLockOne();
        DeadLockTwo deadLockTwo = new DeadLockTwo();
        deadLockOne.start();
        deadLockTwo.start();
    }
    private static class DeadLockOne extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("DeadLockOne is locking lock 1 object.");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("DeadLockOne is waiting for lock 2 object.");
                synchronized (lock2) {
                    System.out.println("DeadLockOne is locking lock 2 object.");
                }
            }
        }
    }
    private static class DeadLockTwo extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("DeadLockTwo is locking lock 2 object.");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("DeadLockTwo is waiting for lock 1 object.");
                synchronized (lock1) {
                    System.out.println("DeadLockTwo is locking lock 1 object.");
                }
            }
        }
    }
}
