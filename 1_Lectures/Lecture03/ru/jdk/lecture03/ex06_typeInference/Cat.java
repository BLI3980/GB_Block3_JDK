package ru.jdk.lecture03.ex06_typeInference;

import ru.jdk.lecture03.ex05_upperLowerBounds.Animal;

public class Cat extends Animal {
    protected Cat(String name) {
        this.name = name;
    }
    protected Cat() {
        this.name = "Cat";
    }
    public void voice(){
        System.out.println("Meow");
    }
}
