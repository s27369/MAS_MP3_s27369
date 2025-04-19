package root.Pojazd;

public class NoAmmoException extends RuntimeException{
    public NoAmmoException() {
        super("Brak amunicji!!!");
    }
}
