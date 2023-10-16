package ru.gb.seminar03.task01;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        GenericClass instance1 = new GenericClass(
                "String",
                new DataInputStream(new FileInputStream("./2_Seminars/Seminar03/Tasks.txt")),
                3.0f);

        System.out.println(instance1.getFieldsClasses());
    }
}
