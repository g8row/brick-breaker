package pack;

import objects.Paddle;
import objects.Brick;
import objects.Grid;
import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        g.setColor(Color.MAGENTA);
        g.fillRect(Paddle.x, Paddle.y, Paddle.WIDTH, Paddle.HEIGHT);

        g.setColor(new Color(0, 0, 0));
        // draw bricks
        g.fillRect(30, 50, 50, 50);
        for (int i = 0; i < Grid.brickgrid.length; i++) {
            for (int j = 0; j < Grid.brickgrid[0].length; j++) {
                if (Grid.brickgrid[i][j].active == 1) {
                    g.fillRect(Grid.brickgrid[i][j].x, Grid.brickgrid[i][j].y, Brick.WIDTH, Brick.HEIGHT);
                }
            }
        }
        repaint();
    }
}
