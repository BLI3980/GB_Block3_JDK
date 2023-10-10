package ru.jdk.lecture03.ex01;

public class Box {
    private Object obj;

    public Box(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void printInfo() {
        System.out.printf("Box(%s): %s\n", obj.getClass().getSimpleName(), obj.toString());
    }
}
