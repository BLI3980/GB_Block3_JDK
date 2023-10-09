package ru.gb.jdk.seminar02.task01;

import ru.gb.jdk.seminar02.task02.ClientThreadListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame implements ClientThreadListener {
    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 550;

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();

    private Server server;
    private ServerListener listener;

    public ServerWindow(ServerListener listener, Server server) {
        this.server = server;
        this.listener = listener;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(WINDOW_POSX, WINDOW_POSY, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        setLayout(new GridLayout(1, 2));

        add(btnStart);
        add(btnStop);

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.stop();
                clientCommand(btnStop.getText() + " was pressed");
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.start();
                clientCommand(btnStart.getText() + " was pressed");

            }
        });

        setVisible(true);
    }

    @Override
    public void clientCommand(String message) {
        listener.generateMessage(message);
    }
}
