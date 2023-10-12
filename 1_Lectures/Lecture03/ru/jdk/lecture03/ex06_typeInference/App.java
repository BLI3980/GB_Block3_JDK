package ru.jdk.lecture03.ex06_typeInference;

import java.util.List;

public class App {
    public static <U> void addBox(U u, List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.setValue(u);
        boxes.add(box);
    }
}
