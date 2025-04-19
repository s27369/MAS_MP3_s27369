package root;

import root.Pojazd.Pojazd;
import root.Pojazd.Teren.PojazdLadowy;
import root.Pojazd.Teren.PojazdPowietrzny;
import root.Pojazd.TypPojazdu.PojazdBojowy;
import root.Pojazd.TypPojazdu.PojazdTransportowy;

public class Main {
    public static void main(String[] args) {
        wieloaspektowe();
    }

    private static void wieloaspektowe(){
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
    }
}
