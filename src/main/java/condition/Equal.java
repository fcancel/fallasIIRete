package condition;

public class Equal extends Condition {

    public Equal (Object value) {
        this.value = value;
    }

    @Override
    public Boolean meetsCondition(Object value) {
        return this.value.equals(value);
    }
}
