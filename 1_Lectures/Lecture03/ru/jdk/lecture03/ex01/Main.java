package ru.jdk.lecture03.ex01;

// Typical classes (non-generic)
public class Main {
    public static void main(String[] args) {
        // Example 1.1
        Box b1 = new Box(20);
        Box b2 = new Box(30);

//        System.out.println(b1.getObj() + b2.getObj()); // Operator "+" cannot be applied to java.lang.Object
        System.out.println((int)b1.getObj() + (int)b2.getObj()); // 50

        // Example 1.2
        Box b3 = new Box("Hello, ");
        Box b4 = new Box("World!");
        System.out.println((String)b1.getObj() + (String)b2.getObj()); // Hello,World!

        // Example 1.3
        if (b1.getObj() instanceof Integer && b2.getObj() instanceof Integer) {
            int sum = (Integer)b1.getObj() + (Integer)b2.getObj();
            System.out.println("sum = " + sum);
        } else {
            System.out.println("The contents of the boxes differ by type");
        }


    }
}
