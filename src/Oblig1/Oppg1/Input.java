package Oblig1.Oppg1;

import javax.swing.JOptionPane;

public class Input implements Runnable{

    @Override
    public void run() {
        while(!Main.melding.equals("quit")){
            Main.melding = JOptionPane.showInputDialog("Input verdi (quit for å avslutte");
        }
    }
    
}
