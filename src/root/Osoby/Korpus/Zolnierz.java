package root.Osoby.Korpus;

import root.Osoby.Osoba;
import root.StrukturyOrganizacyjne.Batalion;

import java.util.ArrayList;
import java.util.List;

public class Zolnierz extends Osoba {
    String stopien;
    Korpus korpus;
    Zolnierz przelozony;

    public Zolnierz(String imie, String nazwisko, String stopien) {
        super(imie, nazwisko);
        try {
            setStopien(stopien);
        }catch (Exception e){
            removeFromExtent();
        }
    }

    private void setStopien(String stopien) throws IllegalArgumentException{
        if(stopien==null || stopien.isBlank()){
            throw new IllegalArgumentException("Stopien nie moze byc null ani blank");
        }
        switch (stopien.toLowerCase()){
            case "szeregowy" :
                this.korpus=Korpus.SZEREGOWY; break;
            case "kapral" :
                this.korpus=Korpus.PODOFICER;
                this.podwladni=new ArrayList<>();
                break;
            case "pułkownik" :
                this.korpus=Korpus.OFICER;
                this.podwladni=new ArrayList<>();
                break;
            default: throw new IllegalArgumentException("akceptowalne stopnie to szeregowy, kapral i pułkownik");
        }
    }

    public String getStopien(){return stopien;}
    public void setPrzelozony(Zolnierz przelozony){
        if(przelozony==null) throw new IllegalArgumentException("Przelozony nie moze byc null");
        if(this.przelozony!=null){
            this.przelozony.removePodwladny(this);
        }
        this.przelozony=przelozony;
    }
    public void removePrzelozony(){
        this.przelozony=null;
    }

//-------------------------------------------------PODOFICER--------------------------------------------------------------
//    podoficer moze miec podwladnych
    List<Zolnierz> podwladni = null;
    public void addPowdladny(Zolnierz z){
        if(this.korpus==Korpus.SZEREGOWY) throw new IllegalStateException("Szeregowy nie może mieć podwładnych");
        this.podwladni.add(z);
        z.setPrzelozony(this);
    }
    public void removePodwladny(Zolnierz z){
        if(z==null) throw new IllegalArgumentException("Podwladny nie moze byc null");
        if(this.podwladni.contains(z)){
            this.podwladni.remove(z);
            z.removePrzelozony();
        }
        else{
            System.out.println("Nie ma takiego podwladnego");
        }
    }

//-------------------------------------------------OFICER-----------------------------------------------------------------
//    oficer moze miec podwladnych i dowodzic batalionem

    Batalion dowodzonyBatalion = null;

    public void setBatalion(Batalion b){
        if(this.korpus!=Korpus.OFICER) throw new IllegalStateException("Tylko oficer może dowodzić batalionem");
        if(b==null) throw new IllegalArgumentException("Batalion nie moze byc null");
        if(this.dowodzonyBatalion!=null){
            this.dowodzonyBatalion.removeDowodca();
        }
        this.dowodzonyBatalion=b;
    }

    public void removeBatalion(){
        this.dowodzonyBatalion=null;
    }

//-------------------------------------------------AWANS-----------------------------------------------------------------
    public void awansuj(){
        if(this.korpus==Korpus.SZEREGOWY){
            this.korpus=Korpus.PODOFICER;
            this.podwladni=new ArrayList<>();
        } else if (this.korpus==Korpus.PODOFICER) {
            this.korpus=Korpus.OFICER;
        }else{
            throw new IllegalStateException("Oficer to najwyższy korpus, nie można dalej awansować");
        }
    }

    public void degraduj(){
        if(this.korpus==Korpus.OFICER){
            this.korpus=Korpus.PODOFICER;
            this.dowodzonyBatalion.removeDowodca();
            this.dowodzonyBatalion=null;
        } else if (this.korpus==Korpus.PODOFICER) {
            this.korpus=Korpus.SZEREGOWY;
            for(Zolnierz z: podwladni){
                z.removePrzelozony();
            }
            this.podwladni=null;
        }else{
            throw new IllegalStateException("Szeregowy to najwyższy korpus, nie można dalej degradować");
        }
    }
}
