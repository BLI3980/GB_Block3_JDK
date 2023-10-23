package ru.gb.seminar04.task01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Task 01: =================================================
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Ben");
        names.add("Jordan");
        names.add("Daniel");
        names.add("Mary");
        names.add("Elizabeth");

        System.out.println("===== Original list:\n" + names);
        Collections.sort(names);
        System.out.println("===== The list after alphabetical sort:\n" + names);

        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println("===== The list after length sort:\n" + names);

    }
}
