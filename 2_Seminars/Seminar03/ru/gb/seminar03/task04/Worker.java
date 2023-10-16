package ru.gb.seminar03.task04;

public class Worker implements Person{
    @Override
    public void doWork() {
        System.out.println(this.getClass().getSimpleName() + ": Ready anytime.");
    }

    @Override
    public void haveRest() {
        System.out.println(this.getClass().getSimpleName() + ": No time for rest.");
    }
}
