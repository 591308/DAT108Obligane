package Oblig1.Oppg3;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Hamburgersjappe {

    public static void main(String[] args ){

        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final  int KAPASITET = 4;

        //Skriv ut header
        skrivUtHeader(kokker, servitorer, KAPASITET);

        BlockingQueue<Integer> burgerko = new LinkedBlockingQueue<Integer>();

        //Starte tråder
        for(String navn: kokker){
            new Kokk(burgerko, navn).start();
        }
        for(String navn: servitorer){
            new Servitor(burgerko, navn).start();
        }
    }

    private static void skrivUtHeader(String[] kokker, String[] servitorer, int KAPASITET) {
        System.out.println(
                "I denne simuleringen har vi \n" +
                "\t" + kokker.length + " kokker " + Arrays.toString(kokker) + "\n" +
                "\t" + servitorer.length + " servitører " + Arrays.toString(servitorer) +"\n" +
                "Kapasiteten til bretter er " + KAPASITET + " hamburgere" + "\n" + "Vi starter...");
    }
}
