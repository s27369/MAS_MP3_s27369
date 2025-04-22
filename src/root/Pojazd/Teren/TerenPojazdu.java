package root.Pojazd.Teren;

import root.ObjectPlus;
import root.Pojazd.Pojazd;

public abstract class TerenPojazdu extends ObjectPlus {
    private Pojazd pojazd;

    private void setPojazd(Pojazd pojazd){
        if (pojazd == null) {
            throw new IllegalArgumentException("Pojazd nie moze byc null");
        }
        this.pojazd = pojazd;
    }

    public void removePojazd(){
        this.pojazd=null;
    }

    @Override
    public void removeFromExtent() {
        if(pojazd!=null){
            removePojazd();
        }
        super.removeFromExtent();
    }
}
