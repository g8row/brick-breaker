package pack;

import objects.Ball;

import objects.Paddle;
import objects.Brick;
import objects.Grid;
import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {
        public static boolean inGame = true;

        protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                if (inGame) {
                        g2d.setColor(new Color(0, 0, 0));
                        // draw bricks
                        for (int i = 0; i < Grid.brickgrid.length; i++) {
                                for (int j = 0; j < Grid.brickgrid[0].length; j++) {
                                        if (Grid.brickgrid[i][j].active == 1) {
                                                g2d.fillRect(Grid.brickgrid[i][j].x, Grid.brickgrid[i][j].y,
                                                                Brick.WIDTH - 1, Brick.HEIGHT - 1);
                                        }
                                }
                        }
                        g2d.setColor(Color.MAGENTA);
                        g2d.fillRect(Paddle.x, Paddle.y, Paddle.WIDTH, Paddle.HEIGHT);

                        g2d.setColor(new Color(0, 152, 0));
                        g2d.fillOval(Ball.x, Ball.y, 10, 10);

                } else if (!inGame) {
                        g.setColor(new Color(0, 0, 0));
                        g.fillRect(0, 0, GUI.WIDTH, GUI.HEIGHT);
                        g2d.setColor(new Color(255, 254, 254));
                        g.setColor(new Color(255, 254, 254));
                        // texta ne bachka
                        Font font = new Font("comicsans", Font.PLAIN, 30);
                        g2d.setFont(font);
                        g.drawString("You lost", 0, 0);

                }
                repaint();
        }
}
