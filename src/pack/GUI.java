package pack;

import objects.Paddle;
import objects.Ball;
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public static final int WIDTH = 600, HEIGHT = 600;
    public static final int WIDTH_OFFSET = 50, HEIGHT_OFFSET = 50;
    Draw draw;
    JPanel jPanel;
    public static JLabel score;

    public void create() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(new Keybinds());

        score = new JLabel();
        score.setBounds(WIDTH - WIDTH_OFFSET, HEIGHT_OFFSET + 10, 50, 20);
        score.setForeground(new Color(0, 0, 0));
        score.setFont(new Font("comicsans", Font.PLAIN, 20));
        score.setText(Integer.toString(Ball.score));
        add(score);

        draw = new Draw();
        draw.setBounds(WIDTH, HEIGHT_OFFSET, WIDTH, HEIGHT);
        draw.setVisible(true);
        add(draw);

        requestFocus();
        setVisible(true);
    }
}
