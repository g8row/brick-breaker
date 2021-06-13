package objects;

import pack.GUI;
import objects.Grid;
import java.util.Iterator;

public class Ball {
    public static int x = 300;
    public static int y = 300;
    public static int HEIGHT = 4;
    public static int WIDTH = 4;
    public static int speedX = 8;
    public static int speedY = 8;

    public static void move() {
        Iterator<int[]> it = Grid.borderblocks.iterator();
        // coordinatite v borderblocks se sudurjat kato [x,y]
        while (it.hasNext()) {
            int[] current = it.next();
            if ((Ball.x > current[0] * Brick.WIDTH && Ball.x + Ball.WIDTH < current[0] * Brick.WIDTH + Brick.WIDTH)
                    && (Ball.y + Ball.HEIGHT < current[1] * Brick.HEIGHT
                            && Ball.y > current[1] * Brick.HEIGHT + Brick.HEIGHT)) {
                speedY *= -1;

            }
        }
        if (((Ball.x > Paddle.x && Ball.x + Ball.WIDTH < Paddle.x + Paddle.WIDTH)
                && (Ball.y + Ball.HEIGHT >= Paddle.y && Ball.y < Paddle.y + Paddle.HEIGHT))
                || (Ball.y < GUI.WIDTH_OFFSET)) {
            speedY *= -1;

        } else if ((Ball.x < GUI.WIDTH_OFFSET) || (Ball.x > GUI.WIDTH - GUI.WIDTH_OFFSET)) {

            speedX *= -1;
        }

        y += speedY;
        x += speedX;

    }
}
