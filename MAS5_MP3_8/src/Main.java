import klasaAbstr.Kotsa;
import klasaAbstr.Piesa;
import klasaAbstr.Zwierz;
import wieloaspektowe.*;
import wielodziedziczenie.Osoba;
import wielodziedziczenie.Pracownik;
import wielodziedziczenie.PracujacyStudent;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Zwierz piesa = new Piesa("Piesa");
        Zwierz kota = new Kotsa("Kota");

        List<Zwierz> lama = new ArrayList<>();

        lama.add(piesa);
        lama.add(kota);

        for (Zwierz zwierz : lama) {
            System.out.println(zwierz.getClass());
        }

        piesa.dajGlos();
        piesa.kimJestem();
        kota.dajGlos();
        kota.kimJestem();


        System.out.println("=====================");

        Osoba pracujaStudent = new PracujacyStudent(new Pracownik(12345), 1234, "s12311");
        System.out.println(pracujaStudent.getDochod());

        System.out.println("=====================");

        CarPart origN = new Original(new New(true), 1235);
        CarPart origU = new Original(new Used(true), 15123);
        CarPart subN = new Substitute(new New(false), "Nie ma");
        CarPart subU = new Substitute(new Used(true), "Tak");

        System.out.println("=====================");




    }
}