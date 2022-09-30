package Oblig2.Oppg2;

import java.util.List;
import java.util.function.Function;


public class Oppg2 {

    private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> funksjon){
        ansatte.forEach(a -> a.setAarslonn(funksjon.apply(a)));
    }

    public static void main(String[] args){

        List<Ansatt> liste = List.of(
                new Ansatt("Vlad", "Civilgin", Kjonn.MANN, "Manther", 650000),
                new Ansatt("Maksim", "Ohvrill", Kjonn.MANN, "Boosmann", 400000),
                new Ansatt("Andrea", "Svendheim", Kjonn.KVINNE, "Cyber-ingeniør", 1000000),
                new Ansatt("Sunniva", "Lothe", Kjonn.KVINNE, "Gullsmeden", 800000),
                new Ansatt("Anton", "Tran", Kjonn.MANN, "Programmer", 500000));

        //Funksjoner
        Function<Ansatt, Integer> kronetillegg = ansatt -> ansatt.getAarslonn() + 1000;
        Function<Ansatt, Integer> prosenttillegg = ansatt -> (ansatt.getAarslonn()*5)/100 + ansatt.getAarslonn();
        Function<Ansatt, Integer> lavLonn = ansatt -> (ansatt.getAarslonn() <= 600000) ? ((ansatt.getAarslonn()*15)/100 + ansatt.getAarslonn()) : ansatt.getAarslonn();
        Function<Ansatt, Integer> prosentMann = ansatt -> (ansatt.getKjonn() == Kjonn.MANN) ? ((ansatt.getAarslonn()*10)/100 + ansatt.getAarslonn()) : ansatt.getAarslonn();

        //i
        System.out.println("\nSkriver ut liste av alle ansatte etter lønnen endres et fast krone tillegg på " + 1000 + " kroner");
        lonnsoppgjor(liste, kronetillegg);
        skrivUtAlle(liste);

        //ii
        System.out.println("\nSkriver ut liste av alle ansatte etter lønnen endres et prosenttillegg på 5% prosent");
        lonnsoppgjor(liste, prosenttillegg);
        skrivUtAlle(liste);

        //iii
        System.out.println("\nSkriver ut liste av alle ansatte etter lønnen endres fast tilleg hvis du har lav lønn");
        lonnsoppgjor(liste, lavLonn);
        skrivUtAlle(liste);

        //iv
        System.out.println("\nSkriver ut liste av alle ansatte etter lønnen endres fast prosenttillegg hvis du er mann");
        lonnsoppgjor(liste, prosentMann);
        skrivUtAlle(liste);
    }


    private static void skrivUtAlle(List<Ansatt> ansatte){
        ansatte.forEach(p -> System.out.println(p));
    }
}
