package ru.gb.jdk.lecture02.common;


import java.awt.*;

public interface Interactable {
    void update(Canvas canvas, float deltaTime);
    void render(Canvas canvas, Graphics g);
}
