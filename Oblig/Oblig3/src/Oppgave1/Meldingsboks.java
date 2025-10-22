package Oppgave1;

import javax.swing.*;

public class Meldingsboks extends Thread {
        private Utskrift printLoop;

    public Meldingsboks(Utskrift printLoop) {
            this.printLoop = printLoop;
        }


        @Override
        public void run() {
            while (true) {

                String input = JOptionPane.showInputDialog("Skriv noe for å skrive det ut, quit for å slutte");
                if (input.equalsIgnoreCase("quit")) {
                    printLoop.stopp();
                    break;
                } else {
                    printLoop.mld(input);
                }
            }
        }
}



