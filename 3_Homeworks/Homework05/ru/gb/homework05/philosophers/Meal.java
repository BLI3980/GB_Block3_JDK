package ru.gb.homework05.philosophers;

public class Meal {
    private String lastPerson = "nobody";

    public String getLastPerson() {
        return lastPerson;
    }

    public void setLastPerson(String lastPerson) {
        this.lastPerson = lastPerson;
    }

    public void eat() {
        System.out.println("eating the meal.");
    }
}
