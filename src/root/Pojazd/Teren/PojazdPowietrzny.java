package root.Pojazd.Teren;

public class PojazdPowietrzny extends TerenPojazdu{
    private final int zasiegLotu, maksWysokoscLotu;

    public PojazdPowietrzny(int zasiegLotu, int maksWysokoscLotu) {
        super();
        try{
            if(zasiegLotu<1){
                throw new IllegalArgumentException("zasiegLotu musi byc wiekszy od 0");
            }
            this.zasiegLotu = zasiegLotu;
            if(maksWysokoscLotu<1){
                throw new IllegalArgumentException("zasiegLotu musi byc wiekszy od 0");
            }
            this.maksWysokoscLotu = maksWysokoscLotu;
        }catch (Exception e){
            removeFromExtent();
        }
    }

    @Override
    public String toString() {
        return "Powietrzny{" +
                "zasiegLotu=" + zasiegLotu +
                ", maksWysokoscLotu=" + maksWysokoscLotu +
                '}';
    }
}
