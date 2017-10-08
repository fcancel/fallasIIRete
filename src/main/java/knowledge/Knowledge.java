package knowledge;

public interface Knowledge {
    Boolean hasKey(String key);
    Boolean hasValue(Object value);
    Boolean hasKeyValue(String key, Object value);
    Object getValue(String key);
    void addKnowdlege(String key, Object value);
}
