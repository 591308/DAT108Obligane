package Oblig1.Oppg2;

import java.util.concurrent.ThreadLocalRandom;

public class Kokk extends Thread{

    private final String navn;
    private final HamburgerBrett brett;

    public Kokk(HamburgerBrett brett, String navn){
        this.brett = brett; this.navn = navn;
    }

    int tid = ThreadLocalRandom.current().nextInt(2000, 6000);
    /**
     * Her skal Kokk ta burgera synvhronizert med servitorer
     */

    public void run(){
        while(true){
            try {
                Thread.sleep(tid);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (brett){
                while(brett.brettet.size() == 4){
                    System.out.println(navn + "(kokk) vil legge på flere burgera men brettet er full, venter!");
                    try {
                        brett.wait();
                    } catch (InterruptedException e) {e.printStackTrace();}
                }
                System.out.println(navn + " (kokk) legger til burger " + brett.leggTil() + ". Brett: " + brett.toList());
                brett.notifyAll();
            }
        }
    }

}
