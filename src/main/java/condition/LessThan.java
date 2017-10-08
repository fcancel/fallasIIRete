package condition;

public class LessThan extends Condition {

    public LessThan(Object value) {
        this.value = value;
    }

    @Override
    public Boolean meetsCondition(Object value) {
        return (Integer) value < (Integer) this.value;
    }
}
