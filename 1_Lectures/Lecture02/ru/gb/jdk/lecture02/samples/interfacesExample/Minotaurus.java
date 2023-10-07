package ru.gb.jdk.lecture02.samples.interfacesExample;

public class Minotaurus implements Human, Bull{
    @Override
    public void walk() {
        System.out.println("Walks on two legs as if it has a human");
    }

    @Override
    public void talk() {
        System.out.println("Does not talk much before it kills you");
    }
}
