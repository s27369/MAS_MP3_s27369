//package root.Osoby;
//
//import root.Kontrakt;
//import root.StrukturyOrganizacyjne.Brygada;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//public class Zolnierz extends Osoba {
//    private String stopien;
////    private Zolnierz przelozony;
//private List<Kontrakt> kontrakty = new ArrayList<>();
//
//    public Zolnierz(String imie, String nazwisko, String stopien) {
//        super(imie, nazwisko);
////        System.out.println("po super w zolnierz: "+this);
//        try {
//            setStopien(stopien);
////            System.out.println("w try w zolnierz: "+this);
//        } catch (Exception e) {
//            e.printStackTrace();
//            removeFromExtent();
//        }
//
//    }
//
//    public void addKontrakt(Brygada b){
////        Kontrakt k = new Kontrakt(this, b, LocalDate.now()+LocalDate., LocalDate.now())
//    }
//
//    /*public Zolnierz(String imie, String nazwisko, String stopien, Zolnierz przelozony) {
//        this(imie, nazwisko, stopien);
//        try {
//            setPrzelozony(przelozony);
//        } catch (Exception e) {
//            e.printStackTrace();
//            removeFromExtent();
//        }
//
//    }
//
//    public Zolnierz getPrzelozony() {
//        return przelozony;
//    }
//
//    public void setPrzelozony(Zolnierz przelozony) {
//        this.przelozony = przelozony;
//    }*/
//
//    public String getStopien() {
//        return stopien;
//    }
//
//    public void setStopien(String stopien) {
//        if(stopien==null || stopien.isBlank()){
//            throw new IllegalArgumentException("stopien nie może być null ani pusty");
//        }
//        this.stopien = stopien;
//    }
//
//    @Override
//    public String toString() {
//        return stopien+" "+super.toString();
//    }
//}
