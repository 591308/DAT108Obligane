package Oblig1.Oppg2;

import java.util.Arrays;

public class HamburgerSjappe {

    public static void main(String[] args ){

        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final  int KAPASITET = 4;

        //Skriv ut header
        skrivUtHeader(kokker, servitorer, KAPASITET);

        HamburgerBrett brett = new HamburgerBrett(KAPASITET);

        //Starte tråder
        for(String navn: kokker){
            new Kokk(brett, navn).start();
        }
        for(String navn: servitorer){
            new Servitor(brett, navn).start();
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
