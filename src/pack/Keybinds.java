package pack;

import objects.Paddle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keybinds implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){

            case KeyEvent.VK_RIGHT:
                if((Paddle.x+Paddle.WIDTH/2)<GUI.WIDTH){
                    Paddle.x+=5;
                    //System.out.println(Paddle.x);
                }
                break;
            case KeyEvent.VK_LEFT:
                if((Paddle.x-Paddle.WIDTH/2)>0){
                    Paddle.x-=5;
                }
                break;
        }
    }



    @Override
    public void keyReleased(KeyEvent e) {

    }
}
