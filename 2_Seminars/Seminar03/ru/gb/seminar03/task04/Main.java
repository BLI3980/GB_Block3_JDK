package ru.gb.seminar03.task04;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rnd = new Random();
        int quantity = rnd.nextInt(10, 20);
        Person[] people = new Person[quantity];
        for (int i = 0; i < quantity; i++) {
            if (rnd.nextBoolean()) {
                people[i] = new Worker();
            } else {
                people[i] = new Slacker();

            }
        }
        System.out.println("People at a workplace:");
        Workplace<Person> workplace = new Workplace<>(people);
        System.out.println("\nPeople in a club:");
        Club<Person> club =new Club<>(people);
    }
}
