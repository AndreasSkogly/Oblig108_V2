package Oppgave3;

import java.util.Random;

public class Servitor extends Thread {
    private final HamburgerBrett brett;
    Random rand = new Random();

    public Servitor(HamburgerBrett brett, String navn) {
        super(navn);
        this.brett = brett;
    }

    public void run() {
        while (true) {
            ventRandom(2,6);
            brett.fjernHamburger(Servitor.currentThread().getName());
        }
    }


    private void ventRandom(int min, int max) {
        int rnd = rand.nextInt(max - min + 1) + min;
        try {
            Thread.sleep(rnd * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
