package root.Pojazd.Teren;

import root.Pojazd.Pojazd;

public abstract class TerenPojazdu {
    private Pojazd pojazd;
    public void setPojazd(Pojazd pojazd){
        if(pojazd==null){
            throw new IllegalArgumentException("Pojazd nie moze byc null");
        }
        this.pojazd = pojazd;
    }
}
