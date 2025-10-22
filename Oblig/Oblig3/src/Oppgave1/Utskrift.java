package Oppgave1;

public class Utskrift extends Thread {
        private boolean fortsett = true;
        private String melding;

        public synchronized void mld(String melding) {
            this.melding = melding;
        }


        public void stopp() {
            fortsett = false;
        }
            @Override
            public void run() {
                while (fortsett) {
                    if (melding == null) {
                        melding = "Ingen melding er kommet enda!";  // her står det bare at det ikke er kommet en melding enda, og dette vil repetere helt frem til man setter noe annet for melding
                    } else {
                        System.out.println(melding);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                        }
                    }
                }
        }
}



