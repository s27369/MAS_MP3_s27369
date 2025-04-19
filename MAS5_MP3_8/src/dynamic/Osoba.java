package dynamic;

public abstract class Osoba {
    private String imie;
    private String nazwisko;

    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Osoba(Osoba osoba) {
        this.imie = osoba.imie;
        this.nazwisko = osoba.nazwisko;

        //przenosi tez pozostale relacje
    }
}
