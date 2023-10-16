package ru.gb.seminar03.task04;

public class Slacker implements Person{
    @Override
    public void doWork() {
        System.out.println(this.getClass().getSimpleName() + ": I'd rather not to.");
    }

    @Override
    public void haveRest() {
        System.out.println(this.getClass().getSimpleName() + ": Will do happily.");
    }
}
