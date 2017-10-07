package rules;

public interface Rule {
    Boolean meetsConditions();
    void fireRule();
}
