package root.Osoby.Korpus;

import root.Osoby.Osoba;
import root.StrukturyOrganizacyjne.Batalion;
import root.ToStringType;

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
                this.korpus=Korpus.SZEREGOWY;
                break;
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
        this.stopien=stopien;
    }

    public String getStopien(){return stopien;}
    public void setPrzelozony(Zolnierz przelozony){
        if(przelozony==null) throw new IllegalArgumentException("Przelozony nie moze byc null");
        if(this.przelozony!=null){
            this.przelozony.removePodwladny(this);
        }
        if(this.przelozony!=przelozony){
            this.przelozony=przelozony;
            przelozony.addPowdladny(this);
        }
    }
    public void removePrzelozony(){
        this.przelozony=null;
    }

//-------------------------------------------------PODOFICER--------------------------------------------------------------
//    podoficer moze miec podwladnych
    List<Zolnierz> podwladni = null;
    public void addPowdladny(Zolnierz z){
        if(getKorpus()==Korpus.SZEREGOWY) throw new IllegalStateException("Szeregowy nie może mieć podwładnych");
        if(!this.podwladni.contains(z)){
            this.podwladni.add(z);
            if(z.getPrzelozony()!=this) z.setPrzelozony(this);
        }

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
        if(getKorpus()!=Korpus.OFICER) throw new IllegalStateException("Tylko oficer może dowodzić batalionem");
        if(b==null) throw new IllegalArgumentException("Batalion nie moze byc null");
        if(getDowodzonyBatalion()!=null){
            this.dowodzonyBatalion.removeDowodca();
        }
        this.dowodzonyBatalion=b;
        b.setDowodca(this);
    }

    public void removeBatalion(){
        this.dowodzonyBatalion=null;
    }

//-------------------------------------------------AWANS-----------------------------------------------------------------
    public void awansuj(){
        if(this.korpus==Korpus.SZEREGOWY){
            this.korpus=Korpus.PODOFICER;
            this.podwladni=new ArrayList<>();
            this.stopien="Kapral";
        } else if (this.korpus==Korpus.PODOFICER) {
            this.korpus=Korpus.OFICER;
            this.stopien="Pułkownik";
        }else{
            throw new IllegalStateException("Oficer to najwyższy korpus, nie można dalej awansować");
        }
    }

    public void degraduj(){
        if(this.korpus==Korpus.OFICER){
            this.korpus=Korpus.PODOFICER;
            this.dowodzonyBatalion.removeDowodca();
            this.dowodzonyBatalion=null;
            this.stopien="Kapral";
        } else if (this.korpus==Korpus.PODOFICER) {
            this.korpus=Korpus.SZEREGOWY;
            for(Zolnierz z: podwladni){
                z.removePrzelozony();
            }
            this.podwladni=null;
            this.stopien="Szeregowy";
        }else{
            throw new IllegalStateException("Szeregowy to najwyższy korpus, nie można dalej degradować");
        }
    }

    @Override
    public String toString() {
        if(this.toStringType == ToStringType.SIMPLE){
            return stopien + " " + super.toString();
        }
        else{
            String podwladniMsg=null, batalionMsg=null;
            if (this.korpus!=Korpus.SZEREGOWY){
                podwladniMsg="[";
                if(this.podwladni.size()==0) podwladniMsg="brak";
                else{
                    for(int i=0; i<this.podwladni.size()-1; i++){
                        podwladniMsg+=this.podwladni.get(i).getSimpleName()+", ";
                    }
                    podwladniMsg+=this.podwladni.get(this.podwladni.size()-1).getSimpleName()+"]";
                }
                if(this.korpus==Korpus.OFICER && this.dowodzonyBatalion!=null){
                    batalionMsg = dowodzonyBatalion.getSimpleName();
                }
            }

            return "Zolnierz \'"+super.toString()+"\'{" +
                    "stopien='" + stopien + '\'' +
                    ", korpus=" + korpus +
                    ", przelozony=" + (przelozony!=null?przelozony.getSimpleName():"brak") +
                    ", podwladni=" + podwladniMsg +
                    ", dowodzonyBatalion=" + batalionMsg +
                    '}';
        }
    }

    public Korpus getKorpus() {
        return korpus;
    }

    public Zolnierz getPrzelozony() {
        return przelozony;
    }

    public Batalion getDowodzonyBatalion() {
        return dowodzonyBatalion;
    }
}
