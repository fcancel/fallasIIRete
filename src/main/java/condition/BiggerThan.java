package condition;

public class BiggerThan extends Condition {

    public BiggerThan(Object value) {
        this.value = value;
    }

    @Override
    public Boolean meetsCondition(Object value) {
        return (Integer) value > (Integer) this.value;
    }
}
