package rules;

import condition.Condition;
import knowledge.Knowledge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Rule {
    protected List<HashMap<String, Condition>> premises = new LinkedList<>();
    protected HashMap<String, Object> implications = new HashMap<>();

    public List<HashMap<String, Condition>> getPremises() {
        return premises;
    }

    public Object getImplication(String key) {
        return implications.get(key);
    }

    public Boolean knowledgeMeetsGivenPremise(Knowledge knowledge, String key, HashMap<String, Condition> premise) {
        return (premise.get(key) != null) ? premise.get(key).meetsCondition(knowledge.getValue(key)) : false;
    }

    public Boolean meetsPremises(Knowledge knowledge) {
        Boolean meetsPremises = true;
        for(HashMap<String, Condition> premise : premises) {
            for(String key : premise.keySet()) {
                meetsPremises = meetsPremises && knowledgeMeetsGivenPremise(knowledge, key, premise);
            }
        }
        return meetsPremises;
    }

    public void fireRule(Knowledge knowledge) {
        for(String key : implications.keySet()) {
            knowledge.addKnowdlege(key, implications.get(key));
        }
    }

    public Boolean hasImplication(String implicationKey, Object implicationValue) {
        return (implications.containsKey(implicationKey)) ? implications.get(implicationKey).toString().equals(implicationValue.toString()) : false;
    }

    protected void addPremise(String key, Condition value) {
        HashMap<String, Condition> premise = new HashMap<>();
        premise.put(key, value);
        premises.add(premise);
    }

}
