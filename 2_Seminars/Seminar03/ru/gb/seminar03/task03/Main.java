package ru.gb.seminar03.task03;

public class Main {
    public static void main(String[] args) {
        String[] array = {"dfsdf", "sdfsdf","sdfdsf" ,"fsdf"};
        CustomIterator<String> myIterator = new CustomIterator<>(array);
        while(myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }

        Integer[] array1 = {1, 2, 3, 4};
        CustomIterator<Integer> myIterator1 = new CustomIterator<>(array1);
        // Each instance of iterator works only once. Therefore, only one of below iterations
        // will work. I.e. either while loop or for-each loop.
        // Unless, iterator() method returns new CustomIterator<>();

//        while(myIterator1.hasNext()) {
//            System.out.println(myIterator1.next());
//        }

        for (Integer item : myIterator1) {
            System.out.println(item);
        }
    }
}
