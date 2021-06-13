package objects;

import pack.GUI;

import java.util.ArrayList;
import java.util.HashSet;

public class Grid {
    public static Brick[][] brickgrid = new Brick[10][20];
    public static HashSet<Brick> borderblocks = new HashSet<>();

    public Grid() {
        for (int i = 0; i < brickgrid.length; i++) {
            for (int j = 0; j < brickgrid[i].length; j++) {
                if (j < 4) {
                    brickgrid[i][j] = new Brick(i * Brick.WIDTH + GUI.WIDTH_OFFSET,j * Brick.HEIGHT + GUI.HEIGHT_OFFSET,1);
                    if (j == 3) {
                        Brick coordinates = new Brick(i * Brick.WIDTH + GUI.WIDTH_OFFSET,j* Brick.HEIGHT + GUI.HEIGHT_OFFSET,1);

                        borderblocks.add(coordinates);
                        //System.out.println(coordinates[0] + " " + coordinates[1]);
                    }

                } else {
                    brickgrid[i][j] = new Brick(i * Brick.WIDTH + GUI.WIDTH_OFFSET,j * Brick.HEIGHT + GUI.HEIGHT_OFFSET,0);
                }
            }
        }
    }

}
