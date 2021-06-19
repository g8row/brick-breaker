package objects;

import pack.Draw;
import pack.GUI;
import pack.Main;
import java.awt.*;
import java.util.HashSet;
import java.util.function.Predicate;

import clocks.Gameclock;

public class Ball {
        public static int x = 270;
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
                                // relative grid coordinates for convenience
                                int currentX = (current.x - GUI.WIDTH_OFFSET) / Brick.WIDTH;
                                int currentY = (current.y - GUI.HEIGHT_OFFSET) / Brick.HEIGHT;

                                toRemove.add(current);
                                Grid.brickgrid[currentX][currentY].active = 0;
                                try {

                                        if (x + 3 <= current.x || x + 1 > current.x + Brick.WIDTH) {
                                                speedX *= -1;
                                        } else {

                                                speedY *= -1;
                                        }

                                } catch (Exception exception) {
                                        exception.printStackTrace();
                                }
                                // adding the neighboring blocks to borderblocks
                                try {
                                        if (currentX != 0) {
                                                toAdd.add(Grid.brickgrid[currentX - 1][currentY]);
                                        }
                                        toAdd.add(Grid.brickgrid[currentX + 1][currentY]);
                                        toAdd.add(Grid.brickgrid[currentX][currentY + 1]);
                                        if (currentY != 0) {

                                                toAdd.add(Grid.brickgrid[currentX][currentY - 1]);
                                        }

                                } catch (Exception e) {
                                        System.out.println("swag");
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

                } else if (Ball.y > GUI.HEIGHT - GUI.HEIGHT_OFFSET) {
                        Draw.inGame = false;
                }

                y += speedY;
                x += speedX;
        }

        public static void reload() {
                x = 300;
                y = 300;
                speedX = 1;
                speedY = 1;

                score = 0;
        }

        public static Rectangle toRect() {
                return new Rectangle(x, y, WIDTH, HEIGHT);
        }
}
