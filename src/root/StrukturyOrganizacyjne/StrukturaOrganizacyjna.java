package root.StrukturyOrganizacyjne;

import root.ObjectPlus;
import root.Osoby.Zolnierz;
import root.ToStringType;

public abstract class StrukturaOrganizacyjna extends ObjectPlus {
    Zolnierz dowodca;
    int numer;
    public ToStringType toStringType=ToStringType.DETAILED;
    protected static final String suffix = "Obrony Terytorialnej";

    public StrukturaOrganizacyjna(int numer) {
        setNumer(numer);
    }

    public StrukturaOrganizacyjna(Zolnierz dowodca, int numer) {
        this(numer);
        setDowodca(dowodca);
    }


    public Zolnierz getDowodca() {
        return dowodca;
    }

    public void setDowodca(Zolnierz dowodca) {
        if(dowodca==null){
            throw new IllegalArgumentException("dowodca nie moze byc null");
        }
        this.dowodca = dowodca;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        if (numer<1){
            throw new IllegalArgumentException("numBrygady musi być większy lub równy 1");
        }
        this.numer = numer;
    }

    @Override
    public String getSimpleName(){
        ToStringType oldType = this.toStringType;
        this.toStringType=ToStringType.SIMPLE;
        String msg = this.toString();
        this.toStringType = oldType;
        return msg;
    }
}
