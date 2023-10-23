package ru.gb.lecture04.collections;

import java.util.ArrayList;
import java.util.LinkedList;

// HashMap<Integer, Integer>
public class HMap {
    private int capacity;
    // A list which has indices as keys and linked lists as buckets
    private ArrayList<LinkedList<Integer>> map;

    public HMap() {
        capacity = 100;
        // Create new instance of the list and fill it with empty linked lists
        map = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            map.add(new LinkedList<>());
        }
    }

    public void put(Integer key, Integer value) {
        int code = key.hashCode() % capacity;
        LinkedList<Integer> list = map.get(code);
        if (!list.contains(value)) {
            list.add(value);
        }
    }


}
