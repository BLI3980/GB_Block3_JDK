package ru.gb.jdk.one.online;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT =230;
    private static final int WINDOW_WIDTH =350;
    JButton btnStart = new JButton("Start new game.");

    JLabel labelGameMode = new JLabel("Choose game mode:");
    ButtonGroup topBtnGroup = new ButtonGroup();
    JRadioButton humanVsHumanButton = new JRadioButton("Human vs Human", true);
    JRadioButton humanVsAiButton = new JRadioButton("Human vs AI", false);

    JLabel labelSizeChoose = new JLabel("Choose field size:");
    JLabel labelSizeSelected = new JLabel("Field size selected:");
    JSlider sliderSize = new JSlider(3, 10, 3);

    JLabel labelWinChoose = new JLabel("Choose field size:");
    JLabel labelWinSelected = new JLabel("Field size selected:");
    JSlider sliderWin = new JSlider(3, 10, 3);

    JPanel topBtns = new JPanel(new GridLayout(2, 1));
    JPanel midBtns = new JPanel(new GridLayout(2, 1));
    JPanel bottomBtns = new JPanel(new GridLayout(2, 1));







    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(0, 3, 3,  3);
                setVisible(false);
            }
        });

        add(btnStart);
    }
}
