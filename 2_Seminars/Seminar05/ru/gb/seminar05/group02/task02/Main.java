package ru.gb.seminar05.group02.task02;

/**
 * Task 02:
 * Create two threads A and B.
 * Thread A changes the state of boolean variable Switcher with time delay of 1000 milliseconds (from true to false and
 * back).
 * Thread B waits for true state of Switcher and prints out to the console the countdown from 100 with time delay of
 * 100 milliseconds.
 * The completion of the work will be when zero will be reached.
 * Either "synchronized" or "volatile" can be used to manage threads.
 */
public class Main {
    public static void main(String[] args) {
        // region Option 1. My version
//        final boolean[] switcher = {true};
//        final int[] countDown = {100};
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (countDown[0] > 0) {
//                    try {
//                        Thread.sleep(1000);
//                        switcher[0] = !switcher[0];
//                        System.out.println(switcher[0]);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (countDown[0] > 0) {
//                    try {
//                        Thread.sleep(100);
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    if (switcher[0]) {
//                        System.out.println(--countDown[0]);
//                    }
//                }
//
//            }
//        });
//        thread1.start();
//        thread2.start();
//        if (countDown[0] == 0) {
//            thread1.interrupt();
//            thread2.interrupt();
//        }
        //endregion
        // region Option 2. Lecturer version
        MyProgramState state = new MyProgramState();
        MyThreadA myThreadA = new MyThreadA(state);
        MyThreadB myThreadB = new MyThreadB(state);

        myThreadA.start();
        myThreadB.start();
        // endregion
    }
}
