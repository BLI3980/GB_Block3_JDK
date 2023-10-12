package ru.jdk.lecture03.ex04_genericsNuances;

import ru.jdk.lecture03.ex02_genericClassesAndMethods.Gbox;

// Working with generic parameters nuances
public class Main {
    public static void main(String[] args) {
        someMethod(new Integer(10));
        someMethod(new Double(10.1));

        // Case with boxTest accepting Gbox<> parameter
        // Gbox<Interger> and Gbox<Float> do not extend Gbox<Number>
//        boxTest(new Gbox<Number>(10));      // works ok
//        boxTest(new Gbox<Integer>(1));      //boxTest(Gbox<Number> n) method accepts only Number
//        boxTest(new Gbox<Float>(1.0f));     //boxTest(Gbox<Number> n) method accepts only Number

        // Case with boxTest accepting Gbox parameter
        boxTest(new Gbox<Number>(10));      // works ok
        boxTest(new Gbox<Integer>(1));      // works ok
        boxTest(new Gbox<Float>(1.0f));     // works ok


    }
    private static void someMethod(Number n) {}
//    private static void boxTest(Gbox<Number> n){}
    private static void boxTest(Gbox n){}
}
