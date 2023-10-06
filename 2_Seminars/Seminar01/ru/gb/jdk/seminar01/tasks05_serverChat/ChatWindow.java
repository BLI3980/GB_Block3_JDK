package ru.gb.jdk.seminar01.tasks05_serverChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

    private static String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));

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

        // Listener for Start button
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
                if (!LogArchive.isExist()) {
                    LogArchive.create();
                } else if (!LogArchive.isBlank()) {
                    log.append(LogArchive.read());
                }
                log.append("Server entry successful at " + dateTime + "\n");
                LogArchive.save(log.getText());
            }
        });

        //Listener for Send button
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendText();
            }
        });

        // Listener for Enter key pressing
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendText();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });

    }

    // Method for actions when sending text to log area.
    private void sendText(){
        String login = loginField.getText().replace("Enter your username: ", "");
        dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
        log.append(dateTime + ", " + login + " : " + textField.getText() + "\n");
        LogArchive.save(log.getText());
        textField.setText("");
    }

}
