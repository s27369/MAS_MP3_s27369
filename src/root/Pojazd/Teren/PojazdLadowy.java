package root.Pojazd.Teren;

public class PojazdLadowy extends TerenPojazdu{
    private final int maksPredkosc;

    public PojazdLadowy(int maksPredkosc) {
        super();
        try{
            if(maksPredkosc<1){
                throw new IllegalArgumentException("predkosc musi byc wieksza od 0");
            }
            this.maksPredkosc = maksPredkosc;
        }catch (Exception e){
            removeFromExtent();
        }

    }

    @Override
    public String toString() {
        return "Ladowy{" +
                "maksPredkosc=" + maksPredkosc +
                '}';
    }
}
