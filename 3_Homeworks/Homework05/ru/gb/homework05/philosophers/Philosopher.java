package ru.gb.homework05.philosophers;

public class Philosopher extends Thread {
    // region Fields
    private String philosopherName;
    private Meal meal;
    private int mealIntakesTaken;
    private final int maxMealsAllowed;
    // endregion

    // region Constructors
    public Philosopher(String name, Meal meal, int intakes) {
        this.philosopherName = name;
        this.meal = meal;
        this.maxMealsAllowed = intakes - 1;
    }
    // endregion

    // region Getters and Setters
    public String getPhilosopherName() {
        return philosopherName;
    }

    public void setPhilosopherName(String philosopherName) {
        this.philosopherName = philosopherName;
    }


    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
    // endregion

    @Override
    public void run() {
        // to track how many times eaten
        while (mealIntakesTaken <= maxMealsAllowed) {
            // to ensure that a philosopher does not eat two times in a row
            if (!meal.getLastPerson().equals(philosopherName)) {
                synchronized (meal) {
                    System.out.print(philosopherName + " is ");
                    meal.eat();
                    meal.setLastPerson(philosopherName);
                    mealIntakesTaken++;
                    try {
                        sleep(1000); // increased from 500, as required in the task, for better viewing
                        System.out.println(philosopherName + " is pondering.\n");
                        sleep(1000); // added sleep for better console viewing
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
