package ru.gb.jdk.lecture02.samples.interfacesExample;

public class Man implements Human{
    @Override
    public void walk() {
        System.out.println("Walks on feet.");
    }

    @Override
    public void talk() {
        System.out.println("Talks meaningful words.. Usually");
    }
}
