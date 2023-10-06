package ru.gb.jdk.lecture02.circles;

import ru.gb.jdk.lecture02.common.Canvas;
import ru.gb.jdk.lecture02.common.Interactable;

import java.awt.*;

public class Background implements Interactable {
    private float time;
    private static final float AMPLITUDE = 255f / 2f;
    private Color color;

    @Override
    public void update(ru.gb.jdk.lecture02.common.Canvas canvas, float deltaTime) {
        time += deltaTime;
        int red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 2f));
        int green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 3f));
        int blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
        color = new Color(red, green, blue);
    }

    @Override
    public void render(Canvas canvas, Graphics g) {
        canvas.setBackground(color);
    }
}
