package ru.gb.seminar03.task04;

public class Workplace<T extends Person> {
    T[] groupOfPeople;

    public Workplace(T[] groupOfPeople) {
        this.groupOfPeople = groupOfPeople;

        for (T person : groupOfPeople) {
            person.doWork();
        }
    }
}
