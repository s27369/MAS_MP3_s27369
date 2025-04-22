package root.Pojazd.Teren;

import root.ObjectPlus;
import root.Pojazd.Pojazd;

public abstract class TerenPojazdu extends ObjectPlus {
    private Pojazd pojazd;

    public TerenPojazdu(Pojazd pojazd) {
        try {
            setPojazd(pojazd);
        }catch (Exception e){
            removeFromExtent();
        }
    }

    public void setPojazd(Pojazd pojazd){
        if (pojazd == null) {
            throw new IllegalArgumentException("Pojazd nie moze byc null");
        }
        this.pojazd = pojazd;
    }
}
