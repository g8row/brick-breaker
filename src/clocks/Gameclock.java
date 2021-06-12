package clocks;

public class Gameclock extends Thread{

    public static boolean running = true;

    public void run(){
        while(running){
            try{

            sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            

        }

    }

}
