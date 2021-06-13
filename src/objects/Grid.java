package objects;

import pack.GUI;
import java.util.HashSet;

public class Grid {
    public static Brick[][] brickgrid = new Brick[10][20];
    public static HashSet<int[]> borderblocks = new HashSet<>();

    public Grid() {
        for (int i = 0; i < brickgrid.length; i++) {
            for (int j = 0; j < brickgrid[i].length; j++) {
                if (j < 4) {
                    brickgrid[i][j] = new Brick();
                    brickgrid[i][j].x = i * Brick.WIDTH + GUI.WIDTH_OFFSET;
                    brickgrid[i][j].y = j * Brick.HEIGHT + GUI.HEIGHT_OFFSET;
                    brickgrid[i][j].active = 1;
                    if (j == 3) {

                        int[] coordingates = { i, j };
                        borderblocks.add(coordingates);
                        System.out.println(coordingates[0] + " " + coordingates[1]);
                    }

                } else {
                    brickgrid[i][j] = new Brick();
                    brickgrid[i][j].x = i * Brick.WIDTH + GUI.WIDTH_OFFSET;
                    brickgrid[i][j].y = j * Brick.HEIGHT + GUI.HEIGHT_OFFSET;
                    brickgrid[i][j].active = 0;

                }
            }
        }
    }

}
