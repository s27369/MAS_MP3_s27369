package root.Pojazd.Teren;

public class PojazdLadowy extends TerenPojazdu{
    private final int maksPredkosc;

    public PojazdLadowy(int maksPredkosc) {
        if(maksPredkosc<1){
            throw new IllegalArgumentException("predkosc musi byc wieksza od 0");
        }
        this.maksPredkosc = maksPredkosc;
    }

}
