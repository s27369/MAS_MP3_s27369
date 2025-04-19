package root.Pojazd;

import root.ObjectPlus;
import root.Pojazd.Teren.TerenPojazdu;

public abstract class Pojazd extends ObjectPlus {
    //wieloaspektowe - typ/teren
    private String rejestracja;
    private TerenPojazdu terenPojazdu;

    public Pojazd(String rejestracja, TerenPojazdu terenPojazdu) {
        setRejestracja(rejestracja);
        setTerenPojazdu(terenPojazdu);
    }

    public void setRejestracja(String rejestracja) {
        if(rejestracja==null || rejestracja.isBlank()){
            throw new IllegalArgumentException("rejestracja nie może być null ani blank");
        }
        this.rejestracja = rejestracja;
    }

    public void setTerenPojazdu(TerenPojazdu terenPojazdu) {
        if(terenPojazdu==null){
            throw new IllegalArgumentException("TerenPojazdu nie moze byc null");
        }
        this.terenPojazdu = terenPojazdu;
    }

    @Override
    public String toString() {
        return "Pojazd["+rejestracja+"]{terenPojazdu=" + terenPojazdu;
    }
}
