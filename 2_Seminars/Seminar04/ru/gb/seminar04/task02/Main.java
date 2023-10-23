package ru.gb.seminar04.task02;

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
        names.add("Jo");
        names.add("Ann");

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

        // Task02: =================================================
        Set<String> namesSet = new HashSet<>(names);
        System.out.println("===== The unique names list (set):\n" + namesSet);
        // Shortest in set
//        System.out.println(namesSet.stream().sorted().toList());
        String shortestName = String.valueOf(namesSet.stream().sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.length() - o2.length();
                    }
                }).findFirst().get());
        System.out.println("Shortest name from the set:\n" + shortestName);

        // Longest in set
        String longestName = String.valueOf(namesSet.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()- o1.length();
            }
        }).findFirst().get());
        System.out.println("The longest name from the set:\n" + longestName);

        // Shortest in list
        // Option 1: sorting using sort(), then getting the first element
        Collections.sort(names);
        System.out.println("The shortest name from the list:\n" + names.get(0));
        // Option 2: using stream().findFirst() to get the first element
        System.out.println(names.stream().findFirst().get());

        // Longest in list
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        // Option 1: using get(0) to get the first element
        String longestInList = names.get(0);
        System.out.println("The longest name from the list:\n" + longestInList);
        // Option 2: using stream().findFirst() to get the first element
        System.out.println(names.stream().findFirst().get());

        // Remove all elements containing "a"
        ArrayList<String> newlist = new ArrayList<>();
        for (String name : names) {
            if (!name.toLowerCase().contains("a")) {
                newlist.add(name);
            }
        }
        System.out.println("The list with names containing 'A' or 'a' removed:\n" + newlist);
        names.removeIf(name -> name.toLowerCase().contains("a"));
        System.out.println(names);





    }
}