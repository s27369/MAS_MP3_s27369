package klasaAbstr;

public class Piesa extends Zwierz {
    public Piesa(String name) {
        super(name);
    }

    @Override
    public void dajGlos() {
        System.out.println("Chał!");
    }
}
