package objects;

import pack.GUI;

public class Grid {
    public static Brick[][] brickgrid = new Brick[30][30];

    public Grid() {
        for (int i = 0; i < brickgrid.length; i++) {
            for (int j = 0; j < brickgrid[i].length; j++) {
                if (j < 4) {
                    brickgrid[i][j] = new Brick();
                    brickgrid[i][j].x = i * Brick.WIDTH + GUI.WIDTH_OFFSET;
                    brickgrid[i][j].y = j * Brick.HEIGHT + GUI.HEIGHT_OFFSET;
                    brickgrid[i][j].active = 1;
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
