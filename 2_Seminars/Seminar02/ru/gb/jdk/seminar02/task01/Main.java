package ru.gb.jdk.seminar02.task01;

public class Main {
    public static void main(String[] args) {
//        new ServerWindow(new Server(new ConsoleServerListener()));
        new ServerWindow(new ConsoleServerListener(), new Server(new LogServerListener("./2_Seminars/Seminar02/log.txt")));
    }
}
