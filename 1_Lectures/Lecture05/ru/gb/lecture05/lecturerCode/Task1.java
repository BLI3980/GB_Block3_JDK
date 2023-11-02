package ru.gb.lecture05.lecturerCode;

public class Task1 implements Runnable{
    private int value;

    public Task1(int value) {
        this.value = value;
    }

    public void increment() {
        value++;
    }

    @Override
    public void run() {
        System.out.println(value);
    }

    @Override
    public String toString() {
        return String.format("(%s)", value);
    }
}
