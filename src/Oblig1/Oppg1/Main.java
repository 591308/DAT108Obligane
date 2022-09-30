package Oblig1.Oppg1;

public class Main {
    static String melding = "Hello, verden";

    public static void main(String[] args) {

        Thread input = new Thread(new Input());
        Thread output = new Thread(new Output());
        input.start();
        output.start();
    }
}
