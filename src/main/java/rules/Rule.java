package rules;

import com.sun.org.apache.xpath.internal.operations.Bool;
import condition.Condition;
import knowledge.Knowledge;

import java.util.HashMap;

public class Rule {
    protected HashMap<String, Condition> premises = new HashMap<>();
    protected HashMap<String, Object> implications = new HashMap<>();

    public HashMap<String, Condition> getPremises() {
        return premises;
    }

    public Object getImplication(String key) {
        return implications.get(key);
    }

    public Boolean knowledgeMeetsPremise(Knowledge knowledge, String key) {
        return premises.get(key).meetsCondition(knowledge.getValue(key));
    }

    public Boolean meetsPremises(Knowledge knowledge) {
        Boolean meetsPremises = true;
        for(String key : premises.keySet()) {
            meetsPremises = meetsPremises && knowledgeMeetsPremise(knowledge, key);
        }
        return meetsPremises;
    }

    public void fireRule(Knowledge knowledge) {
        for(String key : implications.keySet()) {
            knowledge.addKnowdlege(key, implications.get(key));
        }
    }

    public Boolean hasImplication(String implicationKey, Object implicationValue) {
        return (implications.containsKey(implicationKey)) ? implications.get(implicationKey) == (implicationValue) : false;
    }

}
