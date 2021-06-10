package pack;

import objects.Paddle;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public static final int WIDTH=600,HEIGHT=600;
    Draw draw;
    public void create(){
        draw = new Draw();
        addKeyListener(new Keybinds());
        setContentPane(draw);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-WIDTH)/2,((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-HEIGHT)/2,WIDTH,HEIGHT);
        setVisible(true);
    }
}
