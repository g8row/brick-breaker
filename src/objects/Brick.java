
package objects;

import java.awt.*;

public class Brick {

    public int active = 0;
    public final static int WIDTH = 50, HEIGHT = 45;
    public int x;
    public int y;


    public Brick(int x,int y, int active) {
        this.x = x;
        this.y = y;

        this.active = active;
    }

    @Override
    public String toString() {
        return "Brick{" +
                "active=" + active +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public Rectangle toRect(){
        return new Rectangle(x,y,WIDTH,HEIGHT);
    }
}
