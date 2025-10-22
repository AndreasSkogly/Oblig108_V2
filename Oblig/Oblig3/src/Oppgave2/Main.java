package Oppgave2;
public class Main {
    public static void main(String[] args) {
        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final int KAPASITET = 4;


        skrivUtHeader(kokker, servitorer, KAPASITET);

        HamburgerBrett brett = new HamburgerBrett(KAPASITET);

        for (String navn : kokker) {
            new Kokker(brett, navn).start();
        }
        for (String navn : servitorer) {
            new Servitor(brett, navn).start();

        }


    }

    private static void skrivUtHeader(String[] kokker, String[] servitorer, int KAPASITET) {
        System.out.println("I denne simuleringen har vi");
        System.out.println(kokker.length + " kokker ["+ String.join(", ", kokker)+"]");


        System.out.println(servitorer.length + " servitører ["+ String.join(", ", servitorer)+"]");
        System.out.println("Kapasiteten til brettet er " + KAPASITET + " hamburgere.");
        System.out.println("Vi starter ...");
    }
}