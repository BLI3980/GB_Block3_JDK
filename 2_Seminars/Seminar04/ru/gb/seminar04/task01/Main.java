package ru.gb.seminar04.task01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Ben");
        names.add("Jordan");
        names.add("Daniel");
        names.add("Mary");
        names.add("Elizabeth");

        System.out.println(names);
        Collections.sort(names);
        System.out.println(names);

        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(names);

        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });


    }
}
