package Oblig2.Oppg1;

import java.util.function.BiFunction;

public class Oppgave1b {

        public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> func){
            return func.apply(a, b);
        }

        public static void main(String[] args){

            BiFunction<Integer, Integer, Integer> summer = (a, b) -> a + b;
            BiFunction<Integer, Integer, Integer> storreEnn = (a, b) -> Math.max(a, b);
            BiFunction<Integer, Integer, Integer> differanse = (a, b) -> Math.abs(a-b);

            System.out.println("Summen av tall 12 og 13: " + beregn(12, 13, summer));
            System.out.println("Hvilken tall er større -5 eller 3: " + beregn(-5, 3, storreEnn));
            System.out.println("Differanse mellom talla 54 og 45: "+ beregn(54, 45, differanse));
    }
}
