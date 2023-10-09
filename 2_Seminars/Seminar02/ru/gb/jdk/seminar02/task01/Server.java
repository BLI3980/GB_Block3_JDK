package ru.gb.jdk.seminar02.task01;

import ru.gb.jdk.seminar02.task02.ServerThreadListener;

import java.util.Random;

public class Server implements ServerThreadListener {
    private boolean status;
    private ServerListener serverListener;
    private Random random = new Random();

    public Server(ServerListener serverListener) {
        this.status = status;
        this.serverListener = serverListener;
    }

    public void start() {
        String message;
        if (random.nextBoolean() | random.nextBoolean()) { // randomized server response
            if (status) {
                message = "Server is already running.";
            } else {
                status = true;
                message = "Server started.";
            }
        } else {
            message = "Server did not respond";
        }
        serverListener.generateMessage(message);
    }

    public void stop() {
        String message;
        if (random.nextBoolean() | random.nextBoolean()) { // randomized server response
            if (status) {
                status = false;
                message = "Server stopped.";
            } else {
                message = "Server is already stopped.";
            }
        } else {
            message = "Server did not respond";
        }
        serverListener.generateMessage(message);
    }
}
