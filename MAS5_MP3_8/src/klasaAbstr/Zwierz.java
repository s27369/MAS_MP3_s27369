package klasaAbstr;

public abstract class Zwierz { //ObjectPlusie extenduje on przeciez tak byc musi
    private String name;

    public Zwierz(String name) {
        this.name = name;
    }

    public abstract void dajGlos();

    public void kimJestem(){
        System.out.println("Jestem " + name);
    }
}
