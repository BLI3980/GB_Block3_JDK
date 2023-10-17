package ru.gb.homework03.task01;

public class Main {
    public static void main(String[] args) {
        MyCustomCollection<Integer> coll1 = new MyCustomCollection<>();
        System.out.println("\n======== Before filling the array:");
        System.out.println(coll1.info());
        coll1.add(1);
        coll1.add(11);
        coll1.add(11);
        coll1.add(31);
        System.out.println("\n======== After adding the elements to the array:");
        System.out.println(coll1.info());
        coll1.remove(11);
        System.out.println("\n======== After removing an element from the array:");
        System.out.println(coll1.info());
        System.out.println("\n======== Iterating through the elements of the array:");
        coll1.iterate();


    }
}
