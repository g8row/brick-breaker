package pack;

import objects.Paddle;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {


    public Draw(){

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect(Paddle.x,Paddle.y,Paddle.WIDTH,Paddle.HEIGHT);
        repaint();
    }
}
