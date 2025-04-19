package dynamic;

public class Niepelnoletni  extends  Osoba{
   private float sredniaOcen;

    public Niepelnoletni(String imie, String nazwisko, float sredniaOcen) {
        super(imie, nazwisko);
        this.sredniaOcen = sredniaOcen;
    }

    public Pelnoletni stanSiePelnoletni(boolean czyMaPrawojazdy){
        Pelnoletni pelnoletni = new Pelnoletni(this, czyMaPrawojazdy);

        //przełaczenie ze starej klasy na nową

        //usunięcie powiązań ze starą klasą

        //usunięcie starej klasy z ekstensji

        return pelnoletni;
    }
}
