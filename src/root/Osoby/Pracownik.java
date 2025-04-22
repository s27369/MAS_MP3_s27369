package root.Osoby;

public class Pracownik extends Osoba implements IPracownik{
    private int dniowka, dziennyKosztJedzenia, bonus;
    private String stanowisko;

    private ZolnierzNiezawodowy zolnierzNiezawodowy;

    public Pracownik(String imie, String nazwisko, String stanowisko, int dniowka, int dziennyKosztJedzenia, int bonus) {
        super(imie, nazwisko);
        setDniowka(dniowka);
        setDziennyKosztJedzenia(dniowka);
        setStanowisko(stanowisko);
        setDziennyKosztJedzenia(dziennyKosztJedzenia);
        setBonus(bonus);
    }

    @Override
    public int obliczBonus(int liczbaDni) {//za każde przepracowane 20 dni dostaje bonus
        if(liczbaDni>=20) return liczbaDni/20;
        return 0;
    }

    @Override
    public int obliczWynagrodzenie(int liczbaDni) {
        return (dniowka-dziennyKosztJedzenia)*liczbaDni;
    }

    @Override
    public int getZarobki(int liczbaDni) {
        return obliczWynagrodzenie(liczbaDni)+obliczBonus(liczbaDni);
    }

    @Override
    protected void removeFromExtent() {
        removeZolnierzNiezawodowy();
        super.removeFromExtent();
    }

    public void setZolnierzNiezawodowy(ZolnierzNiezawodowy z){
        if(z==null) throw new IllegalArgumentException("ZolnierzNiezawodowy nie moze byc null");
        this.zolnierzNiezawodowy=z;
    }

    public void removeZolnierzNiezawodowy(){
        if(getZolnierzNiezawodowy()!=null){
            ZolnierzNiezawodowy z = getZolnierzNiezawodowy();
            this.zolnierzNiezawodowy=null;
            z.removePracownik();
        }
    }

    public ZolnierzNiezawodowy getZolnierzNiezawodowy() {return zolnierzNiezawodowy;}

    public int getBonus() {return bonus;}
    public void setBonus(int bonus) {this.bonus = bonus;}

    public int getDziennyKosztJedzenia() {return dziennyKosztJedzenia;}

    private void setDziennyKosztJedzenia(int dziennyKosztJedzenia) {this.dziennyKosztJedzenia = dziennyKosztJedzenia;}

    public int getDniowka() {return dniowka;}

    private void setDniowka(int dniowka) {this.dniowka = dniowka;}

    public String getStanowisko() {return stanowisko;}

    public void setStanowisko(String stanowisko) {
        if(stanowisko==null || stanowisko.isBlank()){
            throw new IllegalArgumentException("Stanowisko nie może być null ani blank");
        }
        this.stanowisko = stanowisko;
    }

    @Override
    public String toString() {
        return stanowisko + super.toString() + " (dniowka="+dniowka+")";
    }
}
