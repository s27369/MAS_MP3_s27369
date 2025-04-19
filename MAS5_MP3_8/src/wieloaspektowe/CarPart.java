package wieloaspektowe;

public abstract class CarPart {
    private Condition condition;

    public CarPart(Condition condition) {
        this.condition = condition;
        condition.setCarPart(this);
    }
}
