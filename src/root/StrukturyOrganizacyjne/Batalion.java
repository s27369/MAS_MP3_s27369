package root.StrukturyOrganizacyjne;

import root.Adres;
import root.Osoby.Korpus.Zolnierz;
import root.ToStringType;

public class Batalion extends StrukturaOrganizacyjna {
    //każdy batalion ma swoją jednostkę.
    //dowódcą batalionu może zostać tylko pułkownik.

    //asocjacja zwykla: brygada 1-*batalion
    private Adres adresJednostki;
    private Brygada brygadaMacierzysta;

    public Batalion(int numer, Adres adresJednostki) {
        super(numer);
        setAdresJednostki(adresJednostki);
    }

    public Batalion(int numer, Adres adresJednostki, Brygada brygadaMacierzysta) {
        this(numer, adresJednostki);
        setBrygadaMacierzysta(brygadaMacierzysta);
    }

    public Brygada getBrygadaMacierzysta() {
        return brygadaMacierzysta;
    }

    public void setBrygadaMacierzysta(Brygada brygadaMacierzysta) {
        if(brygadaMacierzysta==null) {//czy argument to null
            throw new IllegalArgumentException("brygadaMacierzysta nie może być null");
        }
        if(this.brygadaMacierzysta!=null) {//czy jest juz przypisana brygada mac.
            System.out.println("Brygada macierzysta dla "+this.getSimpleName()+" jest już przypisana: "+this.brygadaMacierzysta.getSimpleName());
            return ;
        }
        System.out.println("W ramach "+brygadaMacierzysta.getSimpleName()+ " uformowano "+this.getSimpleName());
        this.brygadaMacierzysta = brygadaMacierzysta;
        brygadaMacierzysta.addBatalion(this);
    }

    public void removeBrygadaMacierzysta(){
        if(this.brygadaMacierzysta == null){
            System.out.println("Batalion "+this.getSimpleName()+" nie ma przypisanej brygady macierzystej");
        }else{
            System.out.println("Usuwam przypisanie "+this.getSimpleName()+ " do "+this.brygadaMacierzysta.getSimpleName());

            Brygada brygCopy = this.brygadaMacierzysta;
            this.brygadaMacierzysta=null;
            brygCopy.removeBatalion(this);
        }
    }

    public Adres getAdresJednostki() {
        return adresJednostki;
    }

    public void setAdresJednostki(Adres adresJednostki) {
        if(adresJednostki==null){
            throw new IllegalArgumentException("adresJednostki nie może być null");
        }
        this.adresJednostki = adresJednostki;
    }

    @Override
    public void setDowodca(Zolnierz dowodca) {
        if(dowodca==null){
            throw new IllegalArgumentException("dowodca nie moze byc null");
        }
        if(!dowodca.getStopien().toLowerCase().equals("pułkownik")){
            throw new IllegalArgumentException("Dowódcą batalionu może zostać tylko pułkownik");
        }
        System.out.println(dowodca.getSimpleName()+" obejmuje dowództwo w strukturze organizacyjnej: "+ this.getSimpleName());
        this.dowodca = dowodca;
    }
    public void removeDowodca(){
        this.dowodca=null;
    }

    @Override
    public String toString() {
        if(this.toStringType==ToStringType.SIMPLE){
            return numer + " Batalion";
        }else{
            String brygadaMsg;
            if(this.brygadaMacierzysta==null){
                brygadaMsg = "brak";
            }else{
                brygadaMsg = brygadaMacierzysta.getSimpleName();
            }

            String msg = "Batalion{" +
                    "numer=" + numer +
                    ", brygadaMacierzysta=" + brygadaMsg +
                    ", dowodca=" + dowodca.getSimpleName() +
                    ", adresJednostki=" + adresJednostki +
                    '}';
            return msg;
        }
    }

}
