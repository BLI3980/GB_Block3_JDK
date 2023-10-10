package ru.gb.jdk.seminar02.task04;

public class FrontendDev extends Developer implements Frontend{
    @Override
    void drinkCoffee() {
        System.out.println("Drinks coffee");
    }

    @Override
    void smoke() {
        System.out.println("smokes");
    }

    @Override
    public void doesFront() {
        Frontend.super.doesFront();
    }
}
