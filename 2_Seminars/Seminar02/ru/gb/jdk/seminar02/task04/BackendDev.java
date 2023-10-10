package ru.gb.jdk.seminar02.task04;

public class BackendDev extends Developer implements Backend{
    @Override
    void drinkCoffee() {
        System.out.println("Drinks coffee");
    }

    @Override
    void smoke() {
        System.out.println("smokes");
    }

    @Override
    public void doesBack() {
        Backend.super.doesBack();
    }
}
