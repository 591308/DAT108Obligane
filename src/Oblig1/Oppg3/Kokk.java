package Oblig1.Oppg3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Kokk extends Thread{
    
    String navn;
    int randomsec = ThreadLocalRandom.current().nextInt(2000, 6000);
    BlockingQueue<Integer> burgerko;
    public int maxburg = 4;
    public static int burger = 1;

    public Kokk(BlockingQueue<Integer> burgerko, String navn){
        this.navn = navn;
        this.burgerko = burgerko;
    }

    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(randomsec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(burgerko.size() == maxburg){
    
                try {
                    Thread.sleep(randomsec);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            burgerko.add(burger);
            System.out.println(
                    navn + "(kokk)"+ " legger på hamburger [" + burger + "]. Brett: " + burgerko.toString());
                    burger++;
        }
        
    }
}
