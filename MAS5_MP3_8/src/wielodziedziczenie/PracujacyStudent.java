package wielodziedziczenie;

public class PracujacyStudent extends Student  implements IPracownik{
    private Pracownik pracownik;

    public PracujacyStudent(Pracownik pracownik, float czesne, String skaStudencka) {
        super(czesne, skaStudencka);
        this.pracownik = pracownik;
        pracownik.setPracujacyStudent(this);
    }

    @Override
    public float getPensja() {
        return pracownik.getPensja();
    }

    @Override
    public float getDochod() {
        return super.getDochod() + pracownik.getDochod();
    }
}
