package root.Misja;

import root.ObjectPlus;
import root.ToStringType;

import java.util.EnumSet;

public class Misja extends ObjectPlus implements IMisjaBojowa, IMisjaRozpoznanie, IMisjaSabotaz{
    //overlapping
    private String nazwa;
    private Integer
            iloscAmunicji, //BOJOWA
            iloscC4; //SABOTAZ
    private String meldunek; //ROZPOZNANIE

    private final EnumSet<TypMisji> typyMisji;

    public Misja(String nazwa, EnumSet<TypMisji> typyMisji){
        this.typyMisji = typyMisji;
        try{
            if(typyMisji==null || typyMisji.isEmpty()) throw new NullPointerException("typyMisji nie moze byc null ani puste");
            setNazwa(nazwa);
        }catch(Exception e){
            removeFromExtent();
        }
    }

    public void wykonajMisje(){
        System.out.println("==================Misja rozpoczęta==================");
        System.out.println("Zadanie: "+nazwa);
        if(this.typyMisji.contains(TypMisji.BOJOWA)){
            if(this.iloscAmunicji!=null && this.iloscAmunicji>0) Bojowa();
            else throw new IllegalStateException("Brak amunicji do przeprowadzenia misji BOJOWA");
        }
        if(this.typyMisji.contains(TypMisji.ROZPOZNANIE)){
            Rozpoznanie();
        }
        if(this.typyMisji.contains(TypMisji.SABOTAZ)){
            if(this.iloscC4>0) Sabotaz();
            else throw new IllegalStateException("Brak C4 do przeprowadzenia misji SABOTAZ");
        }
        System.out.println("==================Misja zakonczona==================\n");
    }

    @Override
    public void Bojowa() {
        System.out.println("Kontakt!");
        int ammo = iloscAmunicji;
        for (int i = 0; i < ammo; i++) {
            System.out.print("*strzał* ");
            this.iloscAmunicji-=1;
        }
        System.out.println("\nSiła żywa przeciwnika wyeliminowana");
    }

    @Override
    public void Rozpoznanie() {
        System.out.println("Rekonesans...");
        setMeldunek("Pojazd opancerzony przeciwnika zauważony na (123, 456)");
        System.out.println(this.meldunek);
    }

    @Override
    public void Sabotaz() {
        System.out.println("Sabotaż...");
        int ammo = iloscC4;
        for (int i = 0; i < ammo; i++) {
            System.out.print("BUM! ");
            this.iloscC4-=1;
        }
        System.out.println("\nCele zniszczone");
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        if(nazwa==null || nazwa.isBlank()) throw new IllegalArgumentException("Nazwa nie moze byc null ani blank");
        this.nazwa = nazwa;
    }

    public Integer getIloscAmunicji() {
        if(!typyMisji.contains(TypMisji.BOJOWA)) throw new UnsupportedOperationException("Typ misji nie jest BOJOWA");
        return iloscAmunicji;
    }

    public void setIloscAmunicji(Integer iloscAmunicji) {
        if(!typyMisji.contains(TypMisji.BOJOWA)) throw new UnsupportedOperationException("Typ misji nie jest BOJOWA");
        this.iloscAmunicji = iloscAmunicji;
    }

    public Integer getIloscC4() {
        if(!typyMisji.contains(TypMisji.SABOTAZ)) throw new UnsupportedOperationException("Typ misji nie jest SABOTAZ");
        return iloscC4;
    }

    public void setIloscC4(Integer iloscC4) {
        if(!typyMisji.contains(TypMisji.SABOTAZ)) throw new UnsupportedOperationException("Typ misji nie jest SABOTAZ");
        this.iloscC4 = iloscC4;
    }

    public String getMeldunek() {
        if(!typyMisji.contains(TypMisji.ROZPOZNANIE)) throw new UnsupportedOperationException("Typ misji nie jest ROZPOZNANIE");
        return meldunek;
    }

    public void setMeldunek(String meldunek) {
        if(!typyMisji.contains(TypMisji.ROZPOZNANIE)) throw new UnsupportedOperationException("Typ misji nie jest ROZPOZNANIE");
        this.meldunek = meldunek;
    }

    @Override
    public String toString() {
        if(this.toStringType==ToStringType.SIMPLE) return nazwa;
        else{
            return "Misja{" +
                    "nazwa='" + nazwa + '\'' +
                    ", iloscAmunicji=" + iloscAmunicji +
                    ", iloscC4=" + iloscC4 +
                    ", meldunek='" + meldunek + '\'' +
                    ", typyMisji=" + typyMisji +
                    '}';
        }
    }
}
