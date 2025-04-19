package wielodziedziczenie;


public class Pracownik extends Osoba implements IPracownik {
    private float pensja;
    private PracujacyStudent pracujacyStudent;

    protected void setPracujacyStudent(PracujacyStudent pracujacyStudent) {
        this.pracujacyStudent = pracujacyStudent;
    }

    public Pracownik(float pensja) {
        this.pensja = pensja;
    }

    public float getPensja() {
        return pensja;
    }

    @Override
    public float getDochod() {
        return pensja;
    }
}
