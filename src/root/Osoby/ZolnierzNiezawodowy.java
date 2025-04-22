package root.Osoby;

public class ZolnierzNiezawodowy extends Zolnierz implements IPracownik{
    private int liczbaPrzepracowanychDni;
    private Pracownik pracownik;

    public ZolnierzNiezawodowy(String imie, String nazwisko, String stopien, Pracownik pracownik) {
        super(imie, nazwisko, stopien);
        try{
            setPracownik(pracownik);
        }catch (Exception e){
            removeFromExtent();
        }
    }

    @Override
    public int obliczBonus(int liczbaDni) {
        if(liczbaDni>=20) return liczbaDni/20;
        return 0;
    }

    @Override
    public int obliczWynagrodzenie(int liczbaDni) {
        return this.pracownik.obliczWynagrodzenie(liczbaDni);
    }

    @Override
    public int getZarobki(int liczbaDni) {
        return super.getZarobki(liczbaDni)+obliczWynagrodzenie(liczbaPrzepracowanychDni);
    }

    @Override
    public void removeFromExtent() {
        this.removePracownik();
        super.removeFromExtent();
    }

    private void setPracownik(Pracownik pracownik) {
        if(pracownik==null){
            throw new IllegalArgumentException("pracownik nie moze byc null");
        }
        this.pracownik = pracownik;
        this.pracownik.setZolnierzNiezawodowy(this);
    }

    public void removePracownik(){
        if(getPracownik()!=null){
            Pracownik p = getPracownik();
            this.pracownik=null;
            p.removeZolnierzNiezawodowy();
        }
    }
    public int getLiczbaPrzepracowanychDni() {return liczbaPrzepracowanychDni;}
    public void setLiczbaPrzepracowanychDni(int liczbaPrzepracowanychDni) {this.liczbaPrzepracowanychDni = liczbaPrzepracowanychDni;}
    public Pracownik getPracownik() {return pracownik;}


}
