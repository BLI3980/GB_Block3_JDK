package ru.gb.jdk.lecture02;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private final Sprite[] sprites = new Sprite[10];
    private Background background;

    public Window() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }

        Canvas canvas = new Canvas(this);
        background = new Background();
        add(canvas);

        setVisible(true);
    }

    public void onDrawFrame(Canvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(Canvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
        background.update(canvas, deltaTime);
    }
    private void render(Canvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
        background.render(canvas, g);
    }
}
