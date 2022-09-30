package Oblig1.Oppg1;

public class Output implements Runnable{

    @Override
    public void run() {
        while(!Main.melding.equals("quit")){
            System.out.println(Main.melding);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
