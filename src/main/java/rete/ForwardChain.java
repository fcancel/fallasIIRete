package rete;

import rules.Rule;

import java.util.Iterator;
import java.util.List;

public class ForwardChain implements ReteAlgorithm {
    private List<Rule> rules;
    private Boolean runAgain;

    public ForwardChain(List<Rule> rules) {
        this.rules = rules;
    }

    public void runReteAlgorithm() {
        runAgain = fireFirstRule();
        while(runAgain) {
            runAgain = fireFirstRule();
        }
    }

    private Boolean fireFirstRule() {
        Boolean foundOne = false;
        Iterator<Rule> iterator = rules.iterator();
        while(!foundOne && iterator.hasNext()) {
            Rule rule = iterator.next();
            if (rule.meetsConditions()) {
                rule.fireRule();
                rules.remove(rule);
                foundOne = true;
            }
        }
        return foundOne;
    }
}
