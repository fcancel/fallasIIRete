package rete;

import knowledge.Knowledge;
import rules.Rule;

import java.util.Iterator;
import java.util.List;

public class ForwardChain implements ReteAlgorithm {
    private List<Rule> rules;
    private Knowledge knowledge;
    private Boolean runAgain;

    public ForwardChain(List<Rule> rules, Knowledge knowledge) {
        this.rules = rules;
        this.knowledge = knowledge;
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
            if (rule.meetsPremises(knowledge)) {
                rule.fireRule(knowledge);
                rules.remove(rule);
                foundOne = true;
            }
        }
        return foundOne;
    }
}
