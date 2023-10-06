package ru.gb.jdk.lecture02.circles;

import ru.gb.jdk.lecture02.common.Canvas;
import ru.gb.jdk.lecture02.common.CanvasRepaintListener;
import ru.gb.jdk.lecture02.common.Interactable;
import ru.gb.jdk.lecture02.common.Sprite;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements CanvasRepaintListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    // Here below in this code two classes of sprites and background instances are replaced by one
    // interactable interface:
//    private final Sprite[] sprites = new Sprite[10];
//    private Background background;
    private final Interactable[] interactables = new Interactable[10];

    public Window() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
//        background = new Background();
        interactables[0] = new Background();
        for (int i = 1; i < interactables.length; i++) {
            interactables[i] = new Ball();
        }

        Canvas canvas = new Canvas(this);
        add(canvas);

        setVisible(true);
    }
    @Override
    public void onDrawFrame(Canvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(Canvas canvas, float deltaTime) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].update(canvas, deltaTime);
        }
//        background.update(canvas, deltaTime);
    }
    private void render(Canvas canvas, Graphics g) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].render(canvas, g);
        }
//        background.render(canvas, g);
    }
}
