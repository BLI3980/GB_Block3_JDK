package ru.jdk.lecture03.ex06;

import java.util.ArrayList;

import static ru.jdk.lecture03.ex06.App.addBox;

//Type inference (вывод типов)
public class Main {
    public static void main(String[] args) {
        ArrayList<Box<Cat>> catsInBoxes = new ArrayList<>();
        App.<Cat>addBox(new Cat("Kusya"), catsInBoxes);
        addBox(new Cat("Kusya"), catsInBoxes);

        Box<Cat> box = new Box<Cat>("Some message");
    }


}
