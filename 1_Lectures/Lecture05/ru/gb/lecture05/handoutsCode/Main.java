package ru.gb.lecture05.handoutsCode;

public class Main {
    public static void main(String[] args) {
        // region Create thread ========================================================================================
        // This method of creating threads is more agile and is used in high-level API of managing threads
//        System.out.println(Thread.currentThread().getName());
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                System.out.println("Make some work1!");
//            }
//        };
//        Thread thread = new Thread(runnable);
//        thread.start();
//        // This method of creating threads is more for simple applications
//        System.out.println(Thread.currentThread().getName());
//        ExampleThread exampleThread = new ExampleThread();
//        exampleThread.start();
        // endregion
        // region Interrupt ============================================================================================
        // Example 1 if thread is waiting for blocking method
//        Runnable task1 = () -> {
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                System.out.println("Interrupted");
//            }
//        };
//        Thread thread1 = new Thread(task1);
//        // start the thread
//        thread1.start();
//        // send command to the thread to stop the work
//        thread1.interrupt();
//        // create a pause before further checks. Otherwise, checks perform faster than interrupt command above
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        // check if the thread is still alive
//        System.out.println(thread1.isAlive());
//        // check if the thread status is interrupted
//        System.out.println(thread1.isInterrupted());
//
//        // Example 2 if thread is not waiting for blocking method
//        Runnable task2 = () -> {
//            System.out.println(Thread.currentThread().getName() + " is started");
//            while (!Thread.currentThread().isInterrupted()) {
//
//            }
//            System.out.println(Thread.currentThread().getName() + " is Finished");
//        };
//        Thread thread2 = new Thread(task2);
//        thread2.start();
//        thread2.interrupt();

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        // check if the thread is still alive
//        System.out.println(thread2.isAlive());
//        // check if the thread status is interrupted
//        System.out.println(thread2.isInterrupted());

        // Runnable r = () -> {}; is equal to Runnable r = new Runnable() {@Override public void run() {}};
//        Runnable task3 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + " is started");
//                while (!Thread.currentThread().isInterrupted()) {
//
//                }
//                System.out.println(Thread.currentThread().getName() + " is Finished");
//            }
//        };
//        Thread thread3 = new Thread(task3);
//        thread3.start();
//        thread3.interrupt();


        // endregion
        // region Join =================================================================================================
//        Runnable task = () -> {
//            try {
//                Thread.sleep(2000);
//                System.out.println("Work done");
//            } catch (InterruptedException e) {
//                System.out.println("Interrupted");
//            }
//        };
//        for (int i = 0; i < 3; i++) {
//            Thread thread = new Thread(task);
//            thread.start();
//            System.out.println(thread.getName() + " is started.");
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        System.out.println("Custom threads are finished.");
//
//        for (int i = 0; i < 3; i++) {
//            Thread thread = new Thread();
//            thread.start();
//            System.out.println(thread.getName() + " is started.");
//        }
//        System.out.println("All threads complete the work.");

        // endregion
        // region Simultaneous use of resources ========================================================================
        // By running this code several times we can see that the sequence of threads is different nearly each time.
//        Runnable task = () -> {
//          object += 1;
//            System.out.println(Thread.currentThread().getName());
//        };
//        Thread thread = new Thread(task);
//        thread.start();
//        System.out.println(Thread.currentThread().getName());
//        object += 1;
//        System.out.println(object.intValue());

        // endregion
        // region Synchronizing ========================================================================================
        // Example 1 is below in doSomething method signature
        // Example 2. One instance of custom thread and 10 instances of main threads do not interfere.
//        Object objectToLock = new Object();
//        Runnable task = () -> {
//            synchronized (objectToLock) {
//                System.out.println(Thread.currentThread().getName());
//            }
//        };
//
//        Thread thread = new Thread(task);
//        thread.start();
//        // If we want to have task completed earlier we use method join()
////        thread.join();
//        synchronized (objectToLock) {
//            for (int i = 0; i < 10; i++) {
//                try {
//                    Thread.sleep(1000);
//                    System.out.println("step " + i);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            System.out.println(Thread.currentThread().getName());
//        }
        // endregion
        // region ThreadLocal ==========================================================================================
        new Thread(new ThreadTask()).start();
        // endregion
    }
    public static class ExampleThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Make some work2!");
        }
    }
    public static Integer object = Integer.valueOf(0);

    // Example 1 of synchronizing a method of a class (Main). I.e. a monitor of object this.
    public static synchronized void doSomething() {
        // method logics here
    }
    // Example 2 of synchronizing a method of a class (Main). I.e. a monitor of a class itself.
    // Used for static methods only
    public static void doWork() {
        synchronized (Main.class) {
            // method logics here
        }
    }

    private static Integer counter = 0;
    public static class ThreadTask implements Runnable {
        // ThreadLocal variable.
        ThreadLocal<Integer> threadCounter = new ThreadLocal<>();
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                if (threadCounter.get() != null) {
                    threadCounter.set(threadCounter.get() + 1);
                } else {
                    threadCounter.set(0);
                }
            }
            System.out.println("Counter: " + counter);
            System.out.println("Thread-Local Counter: " + threadCounter.get());
        }
    }
}

