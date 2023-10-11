package ru.jdk.lecture03.ex05;

import java.sql.SQLOutput;

public class Animal {
    protected String name;

    protected Animal() {
        this.name = "Animal";
    }

    @Override
    public String toString() {
        return name;
    }
}
