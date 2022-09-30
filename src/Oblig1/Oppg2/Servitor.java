package Oblig1.Oppg2;

import java.util.concurrent.ThreadLocalRandom;

public class Servitor extends Thread{

    private final String navn;
    private final HamburgerBrett brett;

    public Servitor(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    int tid = ThreadLocalRandom.current().nextInt(2000, 6000);
    /**
     * Her skal Servitor hente  burger frå brettet
     */

    public void run(){

        while(true){
            try {
                Thread.sleep(tid);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(brett){
                while(brett.brettet.size() < 1){
                        System.out.println(navn + "(servitor) vil ta flere burgere men brettet er tom, venter!");
                    try {
                        brett.wait();
                    } catch (InterruptedException e) {e.printStackTrace();}
                }
                System.out.println(navn + "(servitor) tar burger " + brett.fjern() + ". Brett " + brett.toList());
                brett.notifyAll();
            }

        }
    }

}
