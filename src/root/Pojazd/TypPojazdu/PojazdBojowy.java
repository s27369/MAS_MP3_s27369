package root.Pojazd.TypPojazdu;

import root.Pojazd.NoAmmoException;
import root.Pojazd.Pojazd;
import root.Pojazd.Teren.TerenPojazdu;

public class PojazdBojowy extends Pojazd {
    private int iloscAmunicji;

    public PojazdBojowy(String rejestracja, TerenPojazdu terenPojazdu, int iloscAmunicji) {
        super(rejestracja, terenPojazdu);
        try{

        }catch (Exception e){
            removeFromExtent();
        }
        setIloscAmunicji(iloscAmunicji);
    }

    public void zaladujAmunicje(int ilosc){
        if(ilosc<1){
            throw new IllegalArgumentException("Ilosc musi byc >0");
        }
        this.iloscAmunicji+=ilosc;
    }

    public void oddajStrzal() throws NoAmmoException{
        if(iloscAmunicji>0){
            this.iloscAmunicji-=1;
            System.out.print("BAM! ");
        }else{
            throw new NoAmmoException();
        }
    }

    public void ognia(int ileStrzalow){
        try {
            for (int i = ileStrzalow; i > 0; i--) {
                oddajStrzal();
            }
            System.out.println("Ilość amunicji: " + getIloscAmunicji());
        }catch (NoAmmoException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getIloscAmunicji() {
        return iloscAmunicji;
    }

    public void setIloscAmunicji(int iloscAmunicji) {
        if(iloscAmunicji<0){
            throw new IllegalArgumentException("iloscAmunicji musi byc >=0");
        }
        this.iloscAmunicji = iloscAmunicji;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", typ=Bojowy, iloscAmunicji=" + iloscAmunicji +
                '}';
    }
}
