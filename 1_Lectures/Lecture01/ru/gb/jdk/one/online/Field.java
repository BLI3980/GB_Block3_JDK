package ru.gb.jdk.one.online;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Field extends JPanel {
    private static final Random RANDOM = new Random();
    private static final int DOT_PADDING = 5;

    private int gameOverType;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private static final String MSG_WIN_HUMAN = "Human has won!";
    private static final String MSG_WIN_AI = "AI has won!";
    private static final String MSG_DRAW = "The draw!";

    private boolean isGameOver;
    private boolean isInitialized;
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;
    private int fieldSizeX = 3;
    private int fieldSizeY = 3;
    private char[][] field;
    private int panelHeight;
    private int panelWidth;
    private int cellHeight;
    private int cellWidth;
    Field() {
//        setBackground(Color.BLACK);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
        isInitialized = false;
    }

    /**
     * Action after each mouse click.
     * @param e
     */
    private void update(MouseEvent e) {
        if (isGameOver || !isInitialized) return;
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;
        System.out.printf("x=%d, y=%d\n", cellX, cellY);
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellY][cellX] = HUMAN_DOT;
        if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)) return;
        aiTurn();
        repaint();
        if (checkEndGame(AI_DOT, STATE_WIN_AI)) return;
    }

    /**
     * Start Game method
     * @param mode
     * @param fieldSizeX
     * @param fieldSizeY
     * @param winLen
     */
    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen) {
        System.out.printf("Mode: %d; \nSize: x=%d, y=%d; \nWin Length: %d\n",
                mode, fieldSizeX, fieldSizeY, winLen);
        initField();
        isGameOver = false;
        isInitialized = true;
        repaint();
    }

    /**
     * Field rendering method
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    /**
     * Utility method for drawing the field
     * @param g
     */
    private void render(Graphics g) {
        if (!isInitialized) return;
        panelHeight = getHeight();
        panelWidth = getWidth();
        cellHeight = panelHeight / 3;
        cellWidth= panelWidth / 3;

        g.setColor(Color.BLACK);
        for (int h = 0; h < 3; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int w = 0; w < 3; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == EMPTY_DOT) continue;

                if (field[y][x] == HUMAN_DOT) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING *2,
                            cellHeight - DOT_PADDING *2);
                } else if (field[y][x] == AI_DOT) {
                    g.setColor(new Color(0xff0000));
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING *2,
                            cellHeight - DOT_PADDING *2);
                } else {
                    throw new RuntimeException("Unexpected value " + field[y][x] +
                            " in cell: x=" + x + " y=" + y);
                }
            }
        }
        if (isGameOver) showMessageGameOver(g);
    }

    /**
     * Field initialization method
     */
    private void initField() {
        fieldSizeX = 3;
        fieldSizeY = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    /**
     * Method for checking if clicked cell is valid.
     * @param x
     * @param y
     * @return
     */
    private boolean isValidCell(int x, int y) {
        return x>=0 && x < fieldSizeX && y >=0 && y < fieldSizeY;
    }

    /**
     * Method for checking if clicked cell is empty.
     * @param x
     * @param y
     * @return
     */
    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    /**
     * AI turn method
     */
    private void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }

    /**
     * Method for checking if win situation occurred.
     * @param dot
     * @return
     */
    private boolean checkWin(int dot) {
        // Check for any of horizontals
        if (field[0][0] == dot && field[0][1] == dot && field[0][2] == dot) return true;
        if (field[1][0] == dot && field[1][1] == dot && field[1][2] == dot) return true;
        if (field[2][0] == dot && field[2][1] == dot && field[2][2] == dot) return true;
        // Check for any of verticals
        if (field[0][0] == dot && field[1][0] == dot && field[2][0] == dot) return true;
        if (field[0][1] == dot && field[1][1] == dot && field[2][1] == dot) return true;
        if (field[0][2] == dot && field[1][2] == dot && field[2][2] == dot) return true;
        // Check for any of diagonals
        if (field[0][0] == dot && field[1][1] == dot && field[2][2] == dot) return true;
        if (field[0][2] == dot && field[1][1] == dot && field[2][0] == dot) return true;

        return false;
    }

    /**
     * Method for checking if the field is full.
     * @return
     */
    private boolean isFieldFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    /**
     * Method for game over situation actions.
     * @param dot
     * @param gameOverType
     * @return
     */
    private boolean checkEndGame(int dot, int gameOverType) {
        if (checkWin(dot)) {
            this.gameOverType = gameOverType;
            isGameOver = true;
            repaint();
            return true;
        }
        if (isFieldFull()) {
            this.gameOverType = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }

    /**
     * Game Over message method
     * @param g
     */
    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        switch (gameOverType) {
            case STATE_DRAW: g.drawString(MSG_DRAW, 180, getHeight() / 2); break;
            case STATE_WIN_AI: g.drawString(MSG_WIN_AI, 120, getHeight() / 2); break;
            case STATE_WIN_HUMAN: g.drawString(MSG_WIN_HUMAN, 20, getHeight() / 2); break;
            default: throw new RuntimeException("Unexpected gameOver state: " + gameOverType);
        }
    }
}
