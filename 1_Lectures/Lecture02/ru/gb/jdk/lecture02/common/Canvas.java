package ru.gb.jdk.lecture02.common;

import ru.gb.jdk.lecture02.circles.Window;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
//    private final Window controller;
    private final CanvasRepaintListener controller;
    private long lastFrameTime;

    public Canvas(CanvasRepaintListener controller) {
//        setBackground(Color.CYAN);
        this.controller = controller;
        lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        float deltaTime = (System.nanoTime() - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = System.nanoTime();
        repaint();
    }

    public int getLeft() {return 0;}
    public int getRight() {return getWidth() - 1;}
    public int getTop() {return 0;}
    public int getBottom() {return getHeight() - 1;}
}
