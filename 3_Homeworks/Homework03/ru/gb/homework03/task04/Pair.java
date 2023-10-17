package ru.gb.homework03.task04;

public class Pair<T, V> {
    private T first;
    private V second;

    public Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return String.format("The first element of the pair is: %s; The second element of the pair is: %s",
                first.toString(), second.toString());
    }
}
