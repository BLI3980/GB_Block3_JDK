package ru.gb.jdk.seminar01.tasks05_serverChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 550;

    // Top panel for login and server information entry
    private final JPanel panelTop = new JPanel(new GridLayout(2, 2));
    private final JTextField loginField = new JTextField("Enter your username: ");
    private final JTextField passwordField = new JTextField("Enter your password: ");
    private final JTextField ipServerField = new JTextField("Enter IP address of server: ");
    private final JButton btnStart = new JButton("Start");

    // Center area for logging chat messages
    private final JTextArea log = new JTextArea();

    // Bottom panel with text entry field and sending button
    private final JPanel panelBtm = new JPanel(new BorderLayout());
    private final JTextField textField = new JTextField();
    private final JButton btnSend = new JButton("Send");

    public ChatWindow()  {
        // window properties
        setTitle("Chat Client");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(WINDOW_POSX, WINDOW_POSY, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setAlwaysOnTop(true);

        // Adding top panel to window and components to top panel
        add(panelTop, BorderLayout.NORTH);
        panelTop.add(loginField);
        panelTop.add(passwordField);
        panelTop.add(ipServerField);
        panelTop.add(btnStart);

        // Adding bottom panel to window and components to bottom panel
        add(panelBtm, BorderLayout.SOUTH);
        panelBtm.add(textField, BorderLayout.CENTER);
        panelBtm.add(btnSend, BorderLayout.EAST);

        // Adding log area to window
        log.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(log);
        add(scrollPane);

        setVisible(true);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.setText("Server entry successful.");
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText().replace("Enter your username: ", "");
                String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
                log.append(dateTime + ", " + login + " : " + textField.getText() + "\n");
//                log.setText(textField.getText());
                System.out.println(loginField.getName());
                textField.setText("");
            }
        });

    }

}
