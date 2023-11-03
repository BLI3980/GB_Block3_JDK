package ru.gb.seminar05.group02.task01;

public class Friend {
    private String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void bow(Friend friend) {
        System.out.println(name + ": " + friend.getName() + " has bowed me.");
        friend.bowBack(this);
    }

    private synchronized void bowBack(Friend friend) {
        System.out.println(name + ": I'm bowing back to " + friend.getName());
    }
}
