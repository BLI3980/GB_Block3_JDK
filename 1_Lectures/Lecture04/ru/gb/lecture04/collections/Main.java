package ru.gb.lecture04.collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // ========================= COLLECTIONS ==================================
        Collection<Integer> collection = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        // Iterator
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // For-each
        for (Integer integer : collection) {
            System.out.print(integer + " ");
        }
        System.out.println();

        // Stream API
        collection.stream().forEach(value -> System.out.print(value + " "));
        collection.stream().forEach(System.out::println);

        // ========================= ARRAYLIST ==================================
        List<Integer> list = new ArrayList<>(collection);
        // Add to the end:
        // [] <- 1
        // [_], [1] <- 2
        // [1], [_ _], [1 _], [1 2] <- 3
        // [1 2], [_ _ _ _],[1 2 _ _], [1 2 3 _] <- 4 O(1)
        // Insert:
        // [1 2 3 4 5] <- 7[2] O(n)
        // [1 2 3 4 5 _ _ _ _ _]
        // [1 2 3 3 4 5 _ _ _ _]
        // [1 2 7 3 4 5 _ _ _ _]
        // Other list operations:
        // list.get(1) O(1)
        // list.set(1, 2) O(1)
        // list.contains() O(n)

        // ========================= LINKEDLIST ==================================

        LinkList linkList = new LinkList();
        linkList.add(1);

        // ========================= MAP =========================================
        Map<String, Integer> map = Map.of("Hello", 1, "World", 2);
        // for-each
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        for (String s : map.keySet()) {
            System.out.println(s + ": " + map.get(s));
        }
        // Stream
        map.forEach((k, v) -> System.out.println(k + ": " + v));



    }
}
