package ru.smekto4ka.data;

import java.awt.*;

public enum Subject {
    SNAKE(Color.GREEN),
    FOOD(Color.RED),
    NONE(Color.GRAY);

    private Color color;

     Subject(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
