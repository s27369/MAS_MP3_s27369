package wielodziedziczenie;

public class Student extends Osoba {
    private String skaStudencka;
    private float czesne;

    public Student(float czesne, String skaStudencka) {
        this.czesne = czesne;
        this.skaStudencka = skaStudencka;
    }

    public String getSkaStudencka() {
        return skaStudencka;
    }

    public float getCzesne() {
        return czesne;
    }

    @Override
    public float getDochod() {
        return -czesne;
    }
}
