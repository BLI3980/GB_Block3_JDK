package ru.gb.lecture05.lecturerCode;

public class Main {
    public static void main(String[] args) {

        // region Start Thread ========================================================================
//        for (int i = 0; i < 3; i++) {
//            new MyThread().start();
//        }
//        for (int i = 0; i < 5; i++) {
//            new Thread(new MyRunnable()).start();
//        }
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                System.out.println("3. Hello from: " + Thread.currentThread());
//            }).start();
//        }
        // endregion
        // region Simultaneous Threads start and interruption =========================================
        // region Example 1:
//        Thread tic = new Thread(new TicTac1("["));
//        Thread tac = new Thread(new TicTac1("]"));
//        // REMEMBER: if while(true) is used in Thread/Runnable run() method, the thread will live even
//        // after main thread is dead, unless the thread is set to deamon type. So as long as process runs
//        // non-deamon thread will continue to work.
//        // After process is stopped (stop the java program) the thread, obviously, will also stop.
////        tic.setDaemon(true);
////        tac.setDaemon(true);
//        tic.start();
//        tac.start();

        // endregion
        // region Example 2:
//        Thread readThread = new Thread(() -> {
//            Scanner in = new Scanner(System.in);
//            while (in.hasNextLine() && !Thread.interrupted()) {
//                String line = in.nextLine();
//                count++;
//            }
//        });
//        readThread.setDaemon(true);
//        readThread.start();
//        // Notifies the system about the need to interrupt the thread
//        readThread.interrupt();
//
//        while (true) {
//            System.out.println(count + " messages inputted by user.");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        // endregion
        // endregion
        // region Threads join ========================================================================
//        // Creating three instances of myThread, starting and joining each
//        for (int i = 0; i < 3; i++) {
//            MyThread myThread = new MyThread();
//            myThread.start();
//            try {
//                myThread.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        // Creating 5 instances of threads implementing MyRunnable, starting and joining each
//        for (int i = 0; i < 5; i++) {
//            Thread thread = new Thread(new MyRunnable());
//            thread.start();
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        // endregion
        // region Simultaneous use of resources. Synchronized =========================================
//        long start = System.currentTimeMillis();
//        Task2 task2 = new Task2(0);
//        CountDownLatch cdl = new CountDownLatch(3); // Synchronization primitive
//        task2.setCdl(cdl);
//        for (int i = 0; i < 3; i++) {
//            Thread thread = new Thread(task2);
//            thread.start();
//        }
//        try {
//            cdl.await(); // cdl waits until all three threads will finish their countdowns.
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        // increment() method of class task2 must be synchronized in order to avoid simultaneous use
//        // of same variable
//        System.out.println(task2.getValue());
//        long end = System.currentTimeMillis();
//        System.out.println("Time taken: " + (end - start) + " ms.");

        // endregion
        // region Simultaneous use of resources. Use Atomic ===========================================
//        long start = System.currentTimeMillis();
//        Task3 task3 = new Task3(0);
//        CountDownLatch cdl = new CountDownLatch(3); // Synchronization primitive
//        task3.setCdl(cdl);
//        for (int i = 0; i < 3; i++) {
//            Thread thread = new Thread(task3);
//            thread.start();
//        }
//        try {
//            cdl.await(); // cdl waits until all three threads will finish their countdowns.
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        // increment() method of class task2 must be synchronized in order to avoid simultaneous use
//        // of same variable
//        System.out.println(task3.getValue());
//        long end = System.currentTimeMillis();
//        System.out.println("Time taken: " + (end - start) + " ms.");
        // endregion
        // region Simultaneous Threads start and interruption. Synchronized and with sync primitives ==
        // region Example 1:
//        Thread tic = new Thread(new TicTac2("["));
//        Thread tac = new Thread(new TicTac2("]"));
//        // REMEMBER: if while(true) is used in Thread/Runnable run() method, the thread will live even
//        // after main thread is dead, unless the thread is set to deamon type. So as long as process runs
//        // non-deamon thread will continue to work.
//        // After process is stopped (stop the java program) the thread, obviously, will also stop.
//        tic.setDaemon(true);
//        tac.setDaemon(true);
//        tic.start();
//        tac.start();

        // endregion
        // endregion
        // region Concurrent Modification Exception ===================================================
        // region Non-synchronized
//      // Create a list and fill it
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            list.add(i);
//        }
//        // Adding more elements to the list
//        Runnable r1 = () -> {
//            for (int i = 0; i < 1000; i++) {
//                list.add(i);
//            }
//        };
//        // Printing out the contenct of the list
//        Runnable r2 = () -> {
//            for (Integer value : list) {
//                System.out.print( value + " ");
//            }
//            System.out.println();
//        };
//        // Code will fail because we are trying to add and read elements a the same time.
//        new Thread(r1).start();
//        new Thread(r2).start();
        // endregion
        // region Synchronized 1. Using "synchronized"
//        // Create a list and fill it
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            list.add(i);
//        }
//        // Adding more elements to the list
//        Runnable r1 = () -> {
//            for (int i = 0; i < 1000; i++) {
//                synchronized (list) {
//                    list.add(i);
//                }
//            }
//        };
//        // Printing out the contenct of the list
//        Runnable r2 = () -> {
//            synchronized (list) {
//                for (Integer value : list) {
//                    System.out.print(value + " ");
//                }
//            }
//            System.out.println();
//        };
//        new Thread(r1).start();
//        new Thread(r2).start();
        // endregion
        // region Synchronized 2
        // Note: CopyOnWriteArrayList does not guarantee that while reading the copy of the list
        // there will be no concurrent writing to the original list
//        List<Integer> list = new CopyOnWriteArrayList<>();
        // ConcurrentLinkedDeque has blockage at the level of current item of the list
//        Queue<Integer> list = new ConcurrentLinkedDeque<>();
//        for (int i = 0; i < 1000; i++) {
//            list.add(i);
//        }
//        Runnable r1 = () -> {
//            for (int i = 0; i < 1000; i++) {
//                list.add(i);
//            }
//        };
//        Runnable r2 = () -> {
//            for (Integer value : list) {
//                System.out.print(value + " ");
//            }
//            System.out.println();
//        };
//        new Thread(r1).start();
//        new Thread(r2).start();
        // endregion
        // endregion

    }
    private static int count = 0;
}
