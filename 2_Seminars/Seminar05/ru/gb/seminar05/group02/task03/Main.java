package ru.gb.seminar05.group02.task03;

/**
 * Task 03:
 * Three runner must come over to the start of a race.
 * The program must ensure that the race will start only when all three runners are at the start.
 * The program must count "Ready! Steady! Go!"
 * The program must complete its work when all runners will finish the race.
 * Think of synchronization primitives
 */
public class Main {
    public static void main(String[] args) {
        Race race = new Race();
        race.start();
    }
}
