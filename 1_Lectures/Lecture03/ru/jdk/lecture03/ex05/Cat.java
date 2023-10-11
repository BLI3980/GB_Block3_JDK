package ru.jdk.lecture03.ex05;

public class Cat extends Animal{
    protected Cat() {
        this.name = "Cat";
    }
    public void voice(){
        System.out.println("Meow");
    }
}
