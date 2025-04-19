package wieloaspektowe;

public class Substitute extends CarPart{
    private String producent;

    public Substitute(Condition condition, String producent) {
        super(condition);
        this.producent = producent;
    }
}
