package objects;

import java.awt.*;

import pack.GUI;

public class Paddle {
    public final static int WIDTH = 50, HEIGHT = 10;
    public static int x = (GUI.WIDTH + GUI.WIDTH_OFFSET) / 2, y = 500 - HEIGHT / 2;
    public static Rectangle toRect(){
        return new Rectangle(x,y,WIDTH,HEIGHT);
    }
}
