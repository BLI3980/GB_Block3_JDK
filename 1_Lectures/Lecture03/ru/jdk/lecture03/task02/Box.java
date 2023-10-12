package ru.jdk.lecture03.task02;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    protected ArrayList<T> box;
    private T item;

    public T getItem() {
        return item;
    }
    public void setItem(T item) {
        this.item = item;
    }

    public Box() {
        this.box = new ArrayList<>();
    }

    public void add(T fruit) {
        box.add(fruit);
    }

    public float getWeight() {
        if (isEmpty()) return box.size();
        return box.size() * box.get(0).getWeight();
    }

    private boolean isEmpty() {
        return box.size() == 0;
    }

    public <T extends Fruit> boolean compare (Box<T> target) {
        return this.getWeight() == target.getWeight();
    }

    public void move( Box<T> target) {
        for (T item : box) {
            target.add(item);
        }
        box.clear();
    }
}
