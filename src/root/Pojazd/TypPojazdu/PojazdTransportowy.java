package root.Pojazd.TypPojazdu;

import root.Pojazd.Pojazd;
import root.Pojazd.Teren.TerenPojazdu;

public class PojazdTransportowy extends Pojazd {
    private final int maxUdzwig;
    private int obecnyUdzwig;

    public PojazdTransportowy(String rejestracja, TerenPojazdu terenPojazdu, int maxUdzwig) {
        super(rejestracja, terenPojazdu);
        if(maxUdzwig<1)throw new IllegalArgumentException("udzwig musi być >=1");
        this.maxUdzwig=maxUdzwig;
    }

    public void zaladuj(int waga){
        if(waga<1){
            throw new IllegalArgumentException("waga musi byc wieksza od 0");
        }
        if(getObecnyUdzwig()+waga<=getMaxUdzwig()){
            this.obecnyUdzwig+=waga;
        }else{
            System.out.println("Pojazd tego nie udźwignie.");
        }
    }

    public void rozladuj(){
        System.out.println("Rozładowano towar o wadze "+getObecnyUdzwig());
        this.obecnyUdzwig=0;
    }
    public int getMaxUdzwig() {
        return maxUdzwig;
    }
    public int getObecnyUdzwig() {
        return obecnyUdzwig;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", typ=Transportowy, maxUdzwig=" + maxUdzwig +
                ", obecnyUdzwig=" + obecnyUdzwig +
                '}';
    }
}
