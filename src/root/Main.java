package root;

import root.Misja.Misja;
import root.Misja.TypMisji;
import root.Osoby.Osoba;
import root.Osoby.Pracownik;
import root.Osoby.Zolnierz;
import root.Osoby.ZolnierzNiezawodowy;
import root.Pojazd.Pojazd;
import root.Pojazd.Teren.PojazdLadowy;
import root.Pojazd.Teren.PojazdPowietrzny;
import root.Pojazd.TypPojazdu.PojazdBojowy;
import root.Pojazd.TypPojazdu.PojazdTransportowy;
import root.StrukturyOrganizacyjne.Batalion;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        wieloaspektowe();
        dynamic();
        klasaAbstrakcyjna();
        wielodziedziczenie();
        overlapping();
    }
    public static void overlapping(){
        System.out.println("------------------------------------------OVERLAPPING------------------------------------------");
        EnumSet<TypMisji> t1 = EnumSet.of(TypMisji.BOJOWA);
        Misja m1 = new Misja("Misja Bojowa", t1);
        m1.setIloscAmunicji(10);
        m1.wykonajMisje();

        EnumSet<TypMisji> t2 = EnumSet.of(TypMisji.SABOTAZ);
        Misja m2 = new Misja("Misja Sabotaż", t2);
        m2.setIloscC4(3);
        m2.wykonajMisje();

        EnumSet<TypMisji> t3 = EnumSet.of(TypMisji.ROZPOZNANIE);
        Misja m3 = new Misja("Misja Rozpoznanie", t3);
        m3.wykonajMisje();

        EnumSet<TypMisji> t4 = EnumSet.of(TypMisji.BOJOWA, TypMisji.SABOTAZ, TypMisji.ROZPOZNANIE);
        Misja m4 = new Misja("Misja Bojowa, Sabotaż, Rozpoznanie", t4);
        m4.setIloscAmunicji(10);
        m4.setIloscC4(3);
        m4.wykonajMisje();

        ObjectPlus.printExtent();
        m1.removeFromExtent();
        m2.removeFromExtent();
        m3.removeFromExtent();
        m4.removeFromExtent();
        ObjectPlus.printExtent();
    }

    private static void klasaAbstrakcyjna(){
        System.out.println("------------------------------------------KLASA ABSTRAKCYJNA------------------------------------------");
        Osoba z1 = new Zolnierz("Jan", "Kowalski", "Szeregowy");
        Osoba p1 = new Pracownik("Karol", "Nowak", "Konsultant", 200, 40, 100);

        List<Osoba> osoby = new ArrayList<>();
        osoby.add(z1);
        osoby.add(p1);

        for(Osoba o: osoby) System.out.println(o.getSimpleName()+", zarobki=" + o.getZarobki(30));
    }
    private static void wielodziedziczenie(){
        System.out.println("------------------------------------------WIELODZIEDZICZENIE------------------------------------------");
        Zolnierz z1 = new Zolnierz("Jan", "Kowalski", "Szeregowy");
        Pracownik p1 = new Pracownik("Karol", "Nowak", "Konsultant", 200, 40, 100);
        ZolnierzNiezawodowy zn = new ZolnierzNiezawodowy(p1, "Szeregowy");
        System.out.println(z1.getSimpleName()+", zarobki="+z1.getZarobki(30));

        //20 dni przepracowane w firmie i 10 w wojsku
        zn.setLiczbaPrzepracowanychDni(20);
        System.out.println(zn.getSimpleName()+", zarobki="+zn.getZarobki(10));

        //10 dni przepracowane w firmie i 10 w wojsku
        zn.setLiczbaPrzepracowanychDni(10);
        System.out.println(zn.getSimpleName()+", zarobki="+zn.getZarobki(10));
    }
    private static void dynamic(){
        System.out.println("------------------------------------------DYNAMIC------------------------------------------");
        Batalion batalion = new Batalion(181, new Adres("Wesoła", 1, "Warszawa"));
        Zolnierz z1 = new Zolnierz("Jan", "Kowalski", "Szeregowy");
        Zolnierz z2 = new Zolnierz("Piotr", "Kręgiel", "Kapral");
        Zolnierz z3 = new Zolnierz("Karol", "Nowak", "Pułkownik");

        z3.setBatalion(batalion);
        z3.addPowdladny(z2);
        z2.addPowdladny(z1);

        ObjectPlus.printExtent();

        z1.awansuj();
        z2.awansuj();
        z3.degraduj();
        z3.degraduj();

        z3.setPrzelozony(z1);
        z2.setBatalion(batalion);
        z1.setPrzelozony(z2);
//        z1.addPowdladny(z3);

        ObjectPlus.printExtent();
        z2.removeFromExtent();
        ObjectPlus.printExtent();
    }
    private static void wieloaspektowe(){
        System.out.println("------------------------------------------WIELOASPEKTOWE------------------------------------------");
        Pojazd ciezarowka = new PojazdTransportowy("CIE123", new PojazdLadowy(50), 100);
        Pojazd czolg = new PojazdBojowy("CZO234", new PojazdLadowy(20), 10);
        Pojazd heliTransportowy = new PojazdTransportowy("HT345", new PojazdPowietrzny(100, 500), 100);
        Pojazd heliBojowy = new PojazdBojowy("HB456", new PojazdPowietrzny(100, 500), 10);

        ((PojazdBojowy)czolg).ognia(5);
        ((PojazdBojowy)czolg).ognia(6);
        ((PojazdBojowy)czolg).ognia(1);
        ((PojazdBojowy)heliBojowy).ognia(5);
        ((PojazdBojowy)heliBojowy).ognia(6);
        ((PojazdBojowy)heliBojowy).ognia(1);

        ((PojazdTransportowy)ciezarowka).zaladuj(50);
        ((PojazdTransportowy)ciezarowka).zaladuj(60);
        ((PojazdTransportowy)ciezarowka).rozladuj();
        ((PojazdTransportowy)heliTransportowy).zaladuj(50);
        ((PojazdTransportowy)heliTransportowy).zaladuj(60);
        ((PojazdTransportowy)heliTransportowy).rozladuj();

        Pojazd.printExtent();

        ((PojazdTransportowy) ciezarowka).removeFromExtent();

        Pojazd.printExtent();
    }
}
