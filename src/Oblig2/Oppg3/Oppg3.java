package Oblig2.Oppg3;

import Oblig2.Oppg2.Ansatt;
import Oblig2.Oppg2.Kjonn;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Oppg3 {

    public static void main(String[] args) {

        List<Ansatt> liste = List.of(
                new Ansatt("Vlad", "Civilgin", Kjonn.MANN, "Manther sjef", 650000),
                new Ansatt("Maksim", "Ohvrill", Kjonn.MANN, "Boosmann", 400000),
                new Ansatt("Andrea", "Svendheim", Kjonn.KVINNE, "Cyber-ingeniør", 1000000),
                new Ansatt("Sunniva", "Lothe", Kjonn.KVINNE, "Gullsmeden sjef", 800000),
                new Ansatt("Anton", "Tran", Kjonn.MANN, "Programmer", 500000));

        //Liste som inneholder kun etternavnet til ansatte
        System.out.println("Liste ansatt etternavn");
        System.out.println(liste.stream()
                .map(a -> a.getEtternavn())
                .collect(Collectors.toList()));

        //Antall kvinner blant ansatte
        System.out.println("\nAntall kvinner blant ansatte: " + liste.stream()
                .filter(p -> p.getKjonn() == Kjonn.KVINNE)
                .count());

        //Gjennomsnittslønn til kvinnene
        System.out.println("\nGjenn.snitt lønn til kvinnene: " + liste.stream()
                .filter(p -> p.getKjonn() == Kjonn.KVINNE)
                .mapToDouble(p -> p.getAarslonn())
                .average());

        //Alle sjefer lonnsokning på 7% ved bruk av streams direkte. Skriv ut liste av ansatte
        System.out.println("\nListe av alle ansatte etter lonsokning til alle sjefer");
        liste.stream()
                .filter(p -> p.getStilling().contains("sjef"))
                .forEach(p -> p.setAarslonn(((p.getAarslonn()*7/100 + p.getAarslonn()))));
        liste.forEach(System.out::println);

        //Finn ut (true|false) om det er noen ansatte som tjener mer enn 800 000,-
        System.out.println("\nTrue | false om noen tjener over 800 000,-: " + liste.stream().anyMatch(p -> p.getAarslonn() >= 800000));

        //Skriv ut alle de ansatte med System.out.println utan løkke
        System.out.println("\nSkriv ut alle ansatte uten lokke");
        liste.forEach(a -> System.out.println(a));

        //Finn ansatte som har lavest lonn
        System.out.println("\nAnsatte med lavest lonn: ");
        System.out.println(liste.stream()
                .filter(p -> p.getAarslonn() <= 500000)
                .collect(Collectors.toList())
                .stream()
                .map(p -> p.getFornavn())
                .collect(Collectors.toList()));

        //Finn ut summen av alle heltall i [1, 1000 > som er delelig med 3 eller 5]
        System.out.println("\nSummen av alle heltall i 1, 1000 siom er delelig med 3 eller 5");
        System.out.println(IntStream.range(1, 1000).
                filter(x -> (x%3 == 0) || (x%5 == 0)).sum());
    }
}
