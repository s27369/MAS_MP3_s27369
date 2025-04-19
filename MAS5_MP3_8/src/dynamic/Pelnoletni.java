package dynamic;

public class Pelnoletni extends Osoba {
    private boolean czyMaPrawojazdy;

    public Pelnoletni(String imie, String nazwisko, boolean czyMaPrawojazdy) {
        super(imie, nazwisko);
        this.czyMaPrawojazdy = czyMaPrawojazdy;
    }

    public Pelnoletni(Niepelnoletni osoba, boolean czyMaPrawojazdy) {
        super(osoba);
        this.czyMaPrawojazdy = czyMaPrawojazdy;

        //przełaczenie ze starej klasy na nową

        //usunięcie powiązań ze starą klasą

        //usunięcie starej klasy z ekstensji
    }
}
