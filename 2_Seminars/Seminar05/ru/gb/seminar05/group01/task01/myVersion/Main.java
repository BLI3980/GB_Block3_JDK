package ru.gb.seminar05.group01.task01.myVersion;

public class Main {
    public static void main(String[] args) {
        // Create two instances of objects to lock
        ObjectToLock objectToLock1 = new ObjectToLock();
        ObjectToLock objectToLock2 = new ObjectToLock();
        // Initialize one object in another for both objects
        objectToLock1.setOtherObject(objectToLock2);
        objectToLock2.setOtherObject(objectToLock1);
        // create two deadLocking threads
        deadLock(objectToLock1, objectToLock2);
        deadLock(objectToLock2, objectToLock1);
    }
    private static void deadLock(ObjectToLock object1, ObjectToLock object2) {
        new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            object1.call(object2);
        }).start();
    }
}
