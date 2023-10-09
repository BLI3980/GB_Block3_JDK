package ru.gb.jdk.seminar02.task01;

public class ConsoleServerListener implements ServerListener{

    @Override
    public void generateMessage(String msg) {
        System.out.println(msg);
    }
}
