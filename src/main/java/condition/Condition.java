package condition;

public abstract class Condition {

    protected Object value;

    public Object getValue() {
        return value;
    }

    public abstract Boolean meetsCondition(Object value);
}
