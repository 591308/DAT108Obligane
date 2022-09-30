package Oblig1.Oppg3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Servitor extends Thread{
    
String navn;
private final BlockingQueue<Integer> burgerko;

int randomsec = ThreadLocalRandom.current().nextInt(2000,6000);

public Servitor(BlockingQueue<Integer> burgerko, String navn){
    this.navn = navn;
    this.burgerko = burgerko;
}

@Override
public void run(){
    while(true){
        while(burgerko.size() == 0){
            try {
                Thread.sleep(randomsec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Integer take = burgerko.take();

            System.out.println(
                navn + "(servitør)" + " tar av hamburger [" + take + "]. Brett: "+ burgerko);
            Thread.sleep(randomsec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
}
