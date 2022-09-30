package Oblig1.Oppg2;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class HamburgerBrett {

    public Kokk kokk;
    public int kapasitet;
    public LinkedList<Hamburger> brettet = new LinkedList<>();

    public HamburgerBrett(int kapasitet) {
        this.kapasitet = kapasitet;
    }


    public List<Integer> toList() {

        return brettet.stream().map(a -> a.getBurgernr()).collect(Collectors.toList());
    }

    public int fjern() {
        int burger = brettet.getFirst().getBurgernr();
        brettet.removeFirst();
        return burger;
    }
    int count = 1;
    public int leggTil() {
        Hamburger burger = new Hamburger(count);
        brettet.add(burger);
        count++;
        return burger.getBurgernr();
    }
}
