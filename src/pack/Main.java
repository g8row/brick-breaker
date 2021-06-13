package pack;

import objects.Grid;
import clocks.Gameclock;

public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid();
        GUI gui = new GUI();
        Gameclock gc = new Gameclock();

        gui.create();
        gc.start();

    }
}
