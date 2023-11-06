package ru.gb.seminar05.group01.task01.version01;

public class Version01 {
    public static void main(String[] args) {
        ObjectA objectA = new ObjectA();
        ObjectB objectB = new ObjectB();

        Thread thread1 = new Thread(() -> {
            synchronized (objectA) {
                System.out.println("Thread 1 object A.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objectB) {
                    System.out.println("Thread 1 object B.");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (objectB) {
                System.out.println("Thread 2 object B.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objectA) {
                    System.out.println("Thread 2 object A.");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
