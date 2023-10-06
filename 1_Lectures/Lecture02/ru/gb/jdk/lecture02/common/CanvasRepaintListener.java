package ru.gb.jdk.lecture02.common;

import java.awt.*;

public interface CanvasRepaintListener {
    void onDrawFrame(Canvas canvas, Graphics g, float deltaTime);
}
