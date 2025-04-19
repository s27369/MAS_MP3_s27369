package klasaAbstr;

public class Kotsa extends Zwierz{
    public Kotsa(String name) {
        super(name);
    }

    @Override
    public void dajGlos() {
        System.out.println("Miał!");
    }
}
