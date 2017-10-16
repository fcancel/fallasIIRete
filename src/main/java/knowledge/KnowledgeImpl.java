package knowledge;

import java.util.HashMap;

public class KnowledgeImpl implements Knowledge {

    private HashMap<String, Object> hashMap = new HashMap<>();

    @Override
    public Boolean hasKey(String key) {
        return hashMap.containsKey(key);
    }

    @Override
    public Boolean hasValue(Object value) {
        return hashMap.containsValue(value);
    }

    @Override
    public Boolean hasKeyValue(String key, Object value) {
        return hashMap.get(key).toString().equals(value.toString());
    }

    @Override
    public Object getValue(String key) {
        return hashMap.get(key);
    }

    @Override
    public void addKnowdlege(String key, Object value) {
        hashMap.put(key, value);
    }
}
