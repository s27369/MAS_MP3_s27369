package root.Pojazd.Teren;

import root.Pojazd.Pojazd;

public class PojazdPowietrzny extends TerenPojazdu{
    private int zasiegLotu, maksWysokoscLotu;

    public PojazdPowietrzny(int zasiegLotu, int maksWysokoscLotu) {
        try{
            setZasiegLotu(zasiegLotu);
            setMaksWysokoscLotu(maksWysokoscLotu);
        }catch (Exception e){
            removeFromExtent();
        }
    }

    private void setZasiegLotu(int zasiegLotu){
        if(zasiegLotu<1){
            throw new IllegalArgumentException("zasiegLotu musi byc wiekszy od 0");
        }
        this.zasiegLotu = zasiegLotu;
    }
    private void setMaksWysokoscLotu(int maksWysokoscLotu){
        if(maksWysokoscLotu<1){
            throw new IllegalArgumentException("maksWysokoscLotu musi byc wiekszy od 0");
        }
        this.maksWysokoscLotu = maksWysokoscLotu;
    }

    public int getZasiegLotu() {
        return zasiegLotu;
    }

    public int getMaksWysokoscLotu() {
        return maksWysokoscLotu;
    }

    @Override
    public String toString() {
        return "Powietrzny{" +
                "zasiegLotu=" + getZasiegLotu() +
                ", maksWysokoscLotu=" + getMaksWysokoscLotu() +
                '}';
    }
}
