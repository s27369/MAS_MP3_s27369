package root;

import root.Osoby.Zolnierz;
import root.Pojazd.Pojazd;
import root.Pojazd.Teren.PojazdLadowy;
import root.Pojazd.Teren.PojazdPowietrzny;
import root.Pojazd.TypPojazdu.PojazdBojowy;
import root.Pojazd.TypPojazdu.PojazdTransportowy;
import root.StrukturyOrganizacyjne.Batalion;

public class Main {
    public static void main(String[] args) {
//        wieloaspektowe();
        dynamic();
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
