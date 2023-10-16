package ru.gb.seminar03.task04;

public class Club<T extends Person> {
    T[] groupOfPeople;

    public Club(T[] groupOfPeople) {
        this.groupOfPeople = groupOfPeople;

        for (T person : groupOfPeople) {
            person.haveRest();
        }
    }
}
