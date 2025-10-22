package Oppgave3;

public class Hamburger {
    private final int id;
    private final String kokkNavn;

    public Hamburger(int id, String kokkNavn) {
        this.id = id;
        this.kokkNavn = kokkNavn;
    }

    public int getId() {
        return id;
    }

    public String getKokkNavn() {
        return kokkNavn;
    }

    @Override
    public String toString() {
        return "◖" + id + "◗";
    }

}
