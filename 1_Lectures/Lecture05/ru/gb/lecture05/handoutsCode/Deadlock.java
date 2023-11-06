package ru.gb.lecture05.handoutsCode;

public class Deadlock {
    public static void main(String[] args) {
        ObjectToLock objectToLockOne = new ObjectToLock();
        ObjectToLock objectToLockTwo = new ObjectToLock();
        getTread(objectToLockTwo, objectToLockOne);
        getTread(objectToLockOne, objectToLockTwo);

    }
    private static void getTread(ObjectToLock objectToLockOne, ObjectToLock objectToLockTwo) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                objectToLockTwo.stepOne(objectToLockOne);
            }
        }).start();
    }
    static class ObjectToLock {
        public synchronized void stepOne(ObjectToLock object) {
            System.out.println("Step one: " + Thread.currentThread().getName());
            object.stepTwo(this);
        }
        public synchronized void stepTwo(ObjectToLock object) {
            System.out.println("Step two: " + Thread.currentThread().getName());
            object.toString();
        }
    }
}

