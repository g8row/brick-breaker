package objects;

public class Ball{
        public static int x = 20;
        public static int y = 20;
        public static int speedX = 4;
        public static int speedY = 4;

        public static void move(){
            y += speedY;
            x += speedX;
        }


}
