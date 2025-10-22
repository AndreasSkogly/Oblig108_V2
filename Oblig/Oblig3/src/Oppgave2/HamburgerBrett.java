package Oppgave2;

import java.util.LinkedList;
import java.util.List;

public class HamburgerBrett {
    LinkedList<Hamburger> brett = new LinkedList<Hamburger>();
    private final int kapasitet;
    private int hamburgerTeller = 1;


    public HamburgerBrett(int kapasitet) {
        this.kapasitet = kapasitet;
    }

    public int getHamburgerTeller() {
        return hamburgerTeller++;

    }

    public synchronized void leggTilHamburger(Hamburger burger) {
            while (brett.size() >= kapasitet) {
                System.out.println(burger.getKokkNavn() + " (kokk) klar med hamburger, men brett fullt. Venter!");

                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            brett.add(burger);
            System.out.println(burger.getKokkNavn() + " (kokk) legger på hamburger " + burger + " Brett: " +  skrivUtBrett());
            notifyAll();

    }


    public synchronized void fjernHamburger(String servitorNavn) {
            while (brett.isEmpty()) {
                System.out.println(servitorNavn + " (servitør) ønsker å ta hamburger, men brett tomt. Venter!");
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

            Hamburger burger = brett.removeFirst();
            System.out.println(servitorNavn + " (servitør) tar av hamburger " + burger + ". Brett: " +  skrivUtBrett());
            notifyAll();


    }

    public String skrivUtBrett() {
        String resultat = "[";
        for (int i = 0; i < brett.size(); i++) {
            resultat += "◖" + brett.get(i).getId() + "◗";
            if (i < brett.size() - 1) resultat += ", ";
        }
        resultat += "]";
        return resultat;
    }

}




