package condition;

public class MoreThan extends Condition {

    public MoreThan(Object value) {
        this.value = value;
    }

    @Override
    public Boolean meetsCondition(Object value) {
        return (Integer) value > (Integer) this.value;
    }
}
