package root.Pojazd.Teren;

import root.Pojazd.Pojazd;

public class PojazdLadowy extends TerenPojazdu{
    private int maksPredkosc;

    public PojazdLadowy(int maksPredkosc) {
        try{
            setMaksPredkosc(maksPredkosc);
        }catch (Exception e){
            removeFromExtent();
        }

    }
    private void setMaksPredkosc(int maksPredkosc){
        if(maksPredkosc<1){
            throw new IllegalArgumentException("predkosc musi byc wieksza od 0");
        }
        this.maksPredkosc = maksPredkosc;
    }

    public int getMaksPredkosc() {
        return maksPredkosc;
    }

    @Override
    public String toString() {
        return "Ladowy{" +
                "maksPredkosc=" + getMaksPredkosc() +
                '}';
    }
}
