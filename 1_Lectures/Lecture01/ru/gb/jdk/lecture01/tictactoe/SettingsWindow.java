package ru.gb.jdk.lecture01.tictactoe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final int MIN_WIN_LEN = 3;
    private static final int MAX_WIN_LEN = 10;
    private static final String HUMAN_VS_HUMAN_LABEL = "Human vs Human mode.";
    private static final String HUMAN_VS_AI_LABEL = "Human vs AI mode.";
    private static final String FIELD_SIZE_SELECTION_LABEL = "Choose field size";
    private static final String FIELD_SIZE_CHOICE_LABEL = "Selected field size: ";
    private static final String WIN_LEN_SELECTION_LABEL = "Choose win length";
    private static final String WIN_LEN_CHOICE_LABEL = "Selected win length: ";
    private static int sliderFieldSizeValue = 3;
    private static int sliderWinLenValue = 3;
    private static boolean modeValue = true;
    JButton btnStart = new JButton("Start new game.");

    JLabel labelGameMode = new JLabel("Choose game mode:");
    ButtonGroup topBtnGroup = new ButtonGroup();
    JRadioButton humanVsHumanButton = new JRadioButton(HUMAN_VS_HUMAN_LABEL, modeValue);
    JRadioButton humanVsAiButton = new JRadioButton(HUMAN_VS_AI_LABEL, !modeValue);

    JLabel labelSizeChoose = new JLabel(FIELD_SIZE_SELECTION_LABEL);
    JLabel labelSizeSelected = new JLabel(FIELD_SIZE_CHOICE_LABEL + sliderFieldSizeValue);
    JSlider sliderSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, sliderFieldSizeValue);

    JLabel labelWinChoose = new JLabel(WIN_LEN_SELECTION_LABEL);
    JLabel labelWinSelected = new JLabel(WIN_LEN_CHOICE_LABEL + sliderWinLenValue);
    JSlider sliderWin = new JSlider(MIN_WIN_LEN, MAX_WIN_LEN, sliderWinLenValue);

    JPanel grid = new JPanel(new GridLayout(4, 1));
    JPanel topPnl = new JPanel(new GridLayout(2, 1));
    JPanel topBtns = new JPanel(new GridLayout(2, 1));
    JPanel midPnl = new JPanel(new GridLayout(3, 1));
    JPanel midSlider = new JPanel(new GridLayout(2, 1));
    JPanel bottomPnl = new JPanel(new GridLayout(3, 1));
    JPanel bottomSlider = new JPanel(new GridLayout(2, 1));


    SettingsWindow(GameWindow gameWindow) {
        setTitle("Settings Window");
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        // ========= Task01 Student version ============================
        // Group radio buttons so that only one of two can be active at any time
//        topBtnGroup.add(humanVsHumanButton);
//        topBtnGroup.add(humanVsAiButton);
//        // Add to buttons to the top buttons panel
//        topBtns.add(humanVsHumanButton);
//        topBtns.add(humanVsAiButton);
//        // Add to top panel: label, top buttons panel
//        topPnl.add(labelGameMode);
//        topPnl.add(topBtns);
//        // Add to middle panel: label for panel, label for selection, slider
//        midPnl.add(labelSizeChoose);
//        midPnl.add(labelSizeSelected);
//        midPnl.add(sliderSize);
//        // Add to bottom panel: label for panel, label for selection, slider
//        bottomPnl.add(labelWinChoose);
//        bottomPnl.add(labelWinSelected);
//        bottomPnl.add(sliderWin);
//
//        // Add all panels to the grid
//        grid.add(topPnl);
//        grid.add(midPnl);
//        grid.add(bottomPnl);
//        grid.add(btnStart);
//
//        add(grid);
        // ==============================================================
        // ========= Task01 Lecturer version ============================
        setLayout(new GridLayout(10, 1));
        add(new JLabel("Choose game mode: "));
        ButtonGroup bg = new ButtonGroup();
        JRadioButton pvc = new JRadioButton("Human vs AI.");
        JRadioButton pvp = new JRadioButton("Human vs Human.", true);
        bg.add(pvc);
        bg.add(pvp);
        add(pvc);
        add(pvp);
        add(labelSizeChoose);
        add(labelSizeSelected);
        add(sliderSize);
        add(labelWinChoose);
        add(labelWinSelected);
        add(sliderWin);
        add(btnStart);

        // ==============================================================

        // Add listener for displaying top slider value selection
        sliderSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderFieldSizeValue = sliderSize.getValue();
                labelSizeSelected.setText(FIELD_SIZE_CHOICE_LABEL + sliderFieldSizeValue);
                sliderWin.setMaximum(sliderFieldSizeValue);
            }
        });

        // Add listener for displaying bottom slider value selection
        sliderWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderWinLenValue = sliderWin.getValue();
                labelWinSelected.setText(WIN_LEN_CHOICE_LABEL + sliderWinLenValue);
            }
        });


        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mode = 0;
                if (humanVsHumanButton.isSelected()) {
                    mode = 1;
                } else if (humanVsAiButton.isSelected()) {
                    mode = 0;
                } else {
                    throw new RuntimeException("Unknown game mode. ");
                }
                gameWindow.startNewGame(mode, sliderFieldSizeValue, sliderFieldSizeValue,  sliderWinLenValue);
                setVisible(false);
            }
        });

    }
}
