package clocks;

import objects.Ball;
import pack.GUI;
import pack.Main;

public class Gameclock extends Thread {

        public static boolean running = true;

        public void run() {
                while (running) {
                        try {

                                sleep(8);
                                Ball.move();
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }

                }

        }

}
