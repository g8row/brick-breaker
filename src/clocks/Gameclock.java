package clocks;

import objects.Ball;

public class Gameclock extends Thread {

    public static boolean running = true;

    public void run() {
        while (running) {
            try {

                sleep(100);
                Ball.move();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
