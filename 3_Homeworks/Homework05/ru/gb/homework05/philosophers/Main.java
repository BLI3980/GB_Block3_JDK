package ru.gb.homework05.philosophers;

public class Main {
    public static void main(String[] args) {
        Meal meal = new Meal();
        int maxMealsPerPerson = 3;
        Philosopher philosopher1 = new Philosopher("Plato", meal, maxMealsPerPerson);
        Philosopher philosopher2 = new Philosopher("Socrates", meal, maxMealsPerPerson);
        Philosopher philosopher3 = new Philosopher("Aristotle", meal, maxMealsPerPerson);
        Philosopher philosopher4 = new Philosopher("Kant", meal, maxMealsPerPerson);
        Philosopher philosopher5 = new Philosopher("Nietzsche", meal,maxMealsPerPerson);


        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
        philosopher5.start();


    }
}
