package ru.gb.jdk.lecture02.samples.interfacesExample;

public class Ox implements Bull{
    @Override
    public void walk() {
        System.out.println("Walks on hooves.");
    }

    @Override
    public void talk() {
        System.out.println("MooOooOooOoo. Which sometimes human also does.");
    }
}
