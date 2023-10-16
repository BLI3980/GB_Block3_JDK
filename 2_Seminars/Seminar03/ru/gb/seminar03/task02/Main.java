package ru.gb.seminar03.task02;

public class Main {
    public static void main(String[] args) {
        CustomCollection<Integer> coll1 = new CustomCollection<>();
        System.out.println(coll1.info());
        coll1.add(1);
        coll1.add(11);
        coll1.add(11);
        coll1.add(31);
        System.out.println(coll1.info());
        coll1.remove(11);
        System.out.println(coll1.info());

        MyArrayList<String> myArrayList = new MyArrayList<>();

        myArrayList.add("adfa");
        myArrayList.add("adfbfb");
        myArrayList.add("ahh");
        myArrayList.add("hjyky");
//        System.out.println(Arrays.toString(myArrayList)); // No toString method in MyArrayList class

    }
}
