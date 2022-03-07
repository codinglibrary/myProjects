package example.objects;

import java.io.Serializable;

public abstract class Human implements Counter, Serializable {
    private String color;
    public abstract String getColor();
    public abstract void printColor();
}
