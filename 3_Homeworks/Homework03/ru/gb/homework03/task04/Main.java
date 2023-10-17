package ru.gb.homework03.task04;

import ru.gb.homework03.Pair;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(1, "String 1");
        Pair<Integer, String> pair2 = new Pair<>(2, "String 3");
        Pair<Integer, String> pair3 = new Pair<>(3, "String 3");

        System.out.println(pair1.toString());
    }
}
