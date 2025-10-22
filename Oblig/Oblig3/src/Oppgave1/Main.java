package Oppgave1;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Utskrift t1 = new Utskrift();
        t1.start();

        Meldingsboks t2 = new Meldingsboks(t1);
        t2.start();

        System.out.println("Tråder er startet. Venter på at de er ferdige ...");

        t1.join();
        t2.join();

        System.out.println("Begge tråder er ferdige!");
        System.out.println("Main-tråd ferdig!");
    }
}