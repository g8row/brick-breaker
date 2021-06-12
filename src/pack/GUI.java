package pack;

import objects.Paddle;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public static final int WIDTH = 600, HEIGHT = 600;
    public static final int WIDTH_OFFSET = 50, HEIGHT_OFFSET = 50;
    Draw draw;
    JPanel jPanel;

    public void create() {
        draw = new Draw();
        addKeyListener(new Keybinds());
        jPanel = new JPanel(new GridLayout(1, 1));
        jPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jPanel.add(draw);

        setContentPane(jPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - WIDTH) / 2,
                ((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - HEIGHT) / 2, WIDTH + WIDTH_OFFSET,
                HEIGHT + HEIGHT_OFFSET);
        setVisible(true);
    }
}
