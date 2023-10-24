package ru.gb.seminar04.task04;

import java.util.List;
import java.util.Map;

public class UI {
    public static void printPersonnel(List<Employee> list) {
        list.forEach(System.out::println);
    }

    public static void printPersonnel(Map<Integer, String> phonesAndNames) {
        phonesAndNames.forEach((k, v) -> System.out.printf("Name: %s; Phone: %d\n",
                v, k));
    }
}
