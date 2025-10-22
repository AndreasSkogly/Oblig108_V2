package Oppgave3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class HamburgerBrett {
    private final BlockingQueue<Hamburger> brett;
    private final AtomicInteger hamburgerTeller = new AtomicInteger(1);

    public HamburgerBrett(int kapasitet) {
        this.brett = new LinkedBlockingQueue<>(kapasitet);
    }

    public int getHamburgerTeller() {
        return hamburgerTeller.getAndIncrement();

    }

    public void leggTilHamburger(Hamburger burger) {
            try {
                brett.put(burger);
                System.out.println(burger.getKokkNavn() + " (kokk) legger på hamburger " + burger + " Brett: " + skrivUtBrett());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


    }

    public void fjernHamburger(String servitorNavn) {
                try {
                   Hamburger burger = brett.take();
                    System.out.println(servitorNavn + " (servitør) tar av hamburger " + burger + ". Brett: " +  skrivUtBrett());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);

        }
    }

    public String skrivUtBrett() {
        String resultat = "[";
        int i = 0;
        for (Hamburger h : brett) {
            resultat += h.toString();
            if (i < brett.size() - 1) resultat += ", ";
            i++;
        }
        resultat += "]";
        return resultat;
    }


}




