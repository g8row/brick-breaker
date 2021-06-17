package pack;

import objects.Paddle;
import objects.Grid;
import objects.Ball;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import clocks.Gameclock;

public class Keybinds implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

                if (Draw.inGame) {
                        switch (e.getKeyCode()) {

                                case KeyEvent.VK_RIGHT:
                                        if ((Paddle.x + Paddle.WIDTH / 2) < GUI.WIDTH) {
                                                Paddle.x += 12;
                                                // System.out.println(Paddle.x);
                                        }
                                        break;
                                case KeyEvent.VK_LEFT:
                                        if ((Paddle.x - Paddle.WIDTH / 2) > 0) {
                                                Paddle.x -= 12;
                                        }
                                        break;
                        }

                } else {
                        Grid.reload();
                        Ball.reload();
                        Draw.inGame = true;
                        Gameclock.running = true;
                }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
}
