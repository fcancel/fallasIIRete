package rete;

import condition.Condition;
import knowledge.Knowledge;
import rules.Rule;

import java.util.HashMap;
import java.util.List;

public class BackwardChain implements ReteAlgorithm {
    private List<Rule> rules;
    private Knowledge knowledge;
    private String implicationKey;
    private Object implicationValue;

    public BackwardChain(List<Rule> rules, Knowledge knowledge, String implicationKey, Object implicationValue) {
        this.rules = rules;
        this.knowledge = knowledge;
        this.implicationKey = implicationKey;
        this.implicationValue = implicationValue;
    }

    @Override
    public void runReteAlgorithm() {
        runBackwardChain(implicationKey, implicationValue);
    }

    private void runBackwardChain(String implicationKey, Object implicationValue) {
        for(Rule rule : rules) {
            if(rule.hasImplication(implicationKey, implicationValue)) {
                HashMap<String, Condition> premises = rule.getPremises();
                for(String key : premises.keySet()) {
                    if(!rule.knowledgeMeetsPremise(knowledge, key)) {
                        runBackwardChain(key, rule.getPremises().get(key).getValue());
                    }
                }
                if(rule.meetsPremises(knowledge)) {
                    rule.fireRule(knowledge);
                    return;
                }
            }
        }
    }
}
