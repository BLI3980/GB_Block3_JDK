package ru.gb.seminar04.task03;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // One way of creating a test map:
        Map<Integer, String> phoneBook = new HashMap<>();
        phoneBook.put(111, "John");
        phoneBook.put(999, "Jimmy1");
        phoneBook.put(55555, "Jimmy2");
        phoneBook.put(44, "Sarah");
        phoneBook.put(3333333, "Jessica");
        phoneBook.put(2222, "Ivan");

        // Another way of creating a test map (immutable):
        Map<String, String> testMap = new HashMap<>(
                Map.of(
                        "11","adaf",
                        "22","adaf",
                        "33","adaf",
                        "444","adaf",
                        "12323","adaf")
        );

        // Get min phone number
        // Option 1:
        System.out.println(phoneBook.keySet().stream().
                min(Comparator.naturalOrder()).get());
        // Option 2:
        System.out.println(phoneBook.entrySet().stream().
                min(Comparator.comparing(Map.Entry::getKey)).get().getKey());
        // Option 3:
        System.out.println(phoneBook.entrySet().stream().
                min(Comparator.comparing(e -> e.getKey())).get().getKey());

        // Get the last alphabetically sorted name
        // Option 1:
        System.out.println(phoneBook.values().stream().
                max(Comparator.naturalOrder()).get());
        // Option 2:
        System.out.println(phoneBook.entrySet().stream().
                max(Comparator.comparing(Map.Entry::getValue)).get().getValue());
        // Option 3:
        System.out.println(phoneBook.entrySet().stream().
                max(Comparator.comparing(e -> e.getValue())).get().getValue());
    }
}
