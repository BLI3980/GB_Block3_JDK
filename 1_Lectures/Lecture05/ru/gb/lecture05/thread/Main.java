package ru.gb.lecture05.thread;

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
//        Thread tic = new Thread(new TicTac("["));
//        Thread tac = new Thread(new TicTac("]"));
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
        for (int i = 0; i < 3; i++) {
            MyThread myThread = new MyThread();
            myThread.start();
            try {
                myThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // endregion

    }
    private static int count = 0;
}
