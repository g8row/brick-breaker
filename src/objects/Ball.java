package objects;

import pack.GUI;
import objects.Grid;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Predicate;

public class Ball {
    public static int x = 300;
    public static int y = 300;
    public static int HEIGHT = 4;
    public static int WIDTH = 4;
    public static int speedX = 1;
    public static int speedY = 1;

    public static int score = 0;

    public static void move() {

        // coordinatite v borderblocks se sudurjat kato [x,y]
        HashSet<Brick> toAdd = new HashSet<>();
        HashSet<Brick> toRemove = new HashSet<>();
        // Iterator <Brick> it = Grid.borderblocks.iterator();
        Grid.borderblocks.removeIf(new Predicate<Brick>() {
            @Override
            public boolean test(Brick brick) {
                return brick.active == 0;
            }
        });
        for (Brick current : Grid.borderblocks) {
            if (Ball.toRect().intersects(current.toRect()) && current.active != 0) {
                toRemove.add(current);
                Grid.brickgrid[(current.x - GUI.WIDTH_OFFSET) / Brick.WIDTH][(current.y - GUI.HEIGHT_OFFSET)
                        / Brick.HEIGHT].active = 0;
                try {
                    // samo tuk sum rabotil, tiq ifove sa za da sloji v borderblocks susednite no
                    // mai ne raboti mn
                    // osven tva po nqkva prichina ot vreme na vreme hitva nqkvi active=0 blockove i
                    // she se samoubiq
                    if (Grid.brickgrid[(current.x - GUI.WIDTH_OFFSET) / Brick.WIDTH - 1][(current.y - GUI.HEIGHT_OFFSET)
                            / Brick.HEIGHT].active != 0) {
                        toAdd.add(Grid.brickgrid[(current.x - GUI.WIDTH_OFFSET) / Brick.WIDTH
                                - 1][(current.y - GUI.HEIGHT_OFFSET) / Brick.HEIGHT]);
                        System.out.println("check1 " + Grid.brickgrid[(current.x - GUI.WIDTH_OFFSET) / Brick.WIDTH
                                - 1][(current.y - GUI.HEIGHT_OFFSET) / Brick.HEIGHT]);
                    } else {
                        toRemove.add(Grid.brickgrid[(current.x - GUI.WIDTH_OFFSET) / Brick.WIDTH
                                - 1][(current.y - GUI.HEIGHT_OFFSET) / Brick.HEIGHT]);
                        System.out.println("check2");
                    }
                    if (Grid.brickgrid[(current.x - GUI.WIDTH_OFFSET) / Brick.WIDTH + 1][(current.y - GUI.HEIGHT_OFFSET)
                            / Brick.HEIGHT].active != 0) {
                        toAdd.add(Grid.brickgrid[(current.x - GUI.WIDTH_OFFSET) / Brick.WIDTH
                                + 1][(current.y - GUI.HEIGHT_OFFSET) / Brick.HEIGHT]);
                        System.out.println("check3");
                    } else {
                        toRemove.add(Grid.brickgrid[(current.x - GUI.WIDTH_OFFSET) / Brick.WIDTH
                                + 1][(current.y - GUI.HEIGHT_OFFSET) / Brick.HEIGHT]);
                        System.out.println("check4");
                    }
                    if (Grid.brickgrid[(current.x - GUI.WIDTH_OFFSET) / Brick.WIDTH][(current.y - GUI.HEIGHT_OFFSET)
                            / Brick.HEIGHT - 1].active != 0) {
                        toAdd.add(Grid.brickgrid[(current.x - GUI.WIDTH_OFFSET)
                                / Brick.WIDTH][(current.y - GUI.HEIGHT_OFFSET) / Brick.HEIGHT - 1]);
                        System.out.println("check5");
                    } else {
                        toRemove.add(Grid.brickgrid[(current.x - GUI.WIDTH_OFFSET)
                                / Brick.WIDTH][(current.y - GUI.HEIGHT_OFFSET) / Brick.HEIGHT - 1]);
                        System.out.println("check6");
                    }
                    if (Grid.brickgrid[(current.x - GUI.WIDTH_OFFSET) / Brick.WIDTH][(current.y - GUI.HEIGHT_OFFSET)
                            / Brick.HEIGHT + 1].active != 0) {
                        toAdd.add(Grid.brickgrid[(current.x - GUI.WIDTH_OFFSET)
                                / Brick.WIDTH][(current.y - GUI.HEIGHT_OFFSET) / Brick.HEIGHT + 1]);
                        System.out.println("check7");
                    } else {
                        toRemove.add(Grid.brickgrid[(current.x - GUI.WIDTH_OFFSET)
                                / Brick.WIDTH][(current.y - GUI.HEIGHT_OFFSET) / Brick.HEIGHT + 1]);
                        System.out.println("check8");
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                if (x + WIDTH <= current.x || x > current.x + Brick.WIDTH) {
                    speedX *= -1;
                } else {
                    speedY *= -1;
                }

                score += 10;
                GUI.score.setText(Integer.toString(score));
                System.out.println(score);
                System.out.println("hit " + current.toString());
            }
        }
        Grid.borderblocks.addAll(toAdd);
        Grid.borderblocks.removeAll(toRemove);

        if (((Ball.x > Paddle.x && Ball.x + Ball.WIDTH < Paddle.x + Paddle.WIDTH)
                && (Ball.y + Ball.HEIGHT >= Paddle.y && Ball.y < Paddle.y + Paddle.HEIGHT))
                || (Ball.y < GUI.WIDTH_OFFSET)) {
            speedY *= -1;

        } else if ((Ball.x < GUI.WIDTH_OFFSET) || (Ball.x > GUI.WIDTH - GUI.WIDTH_OFFSET)) {
            speedX *= -1;
        }
        y += speedY;
        x += speedX;
    }

    public static Rectangle toRect() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}
