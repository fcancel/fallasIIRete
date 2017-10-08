import knowledge.Animal;
import knowledge.Knowledge;
import knowledge.KnowledgeImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import rete.BackwardChain;
import rete.ForwardChain;
import rete.ReteAlgorithm;
import rules.*;
import utils.*;

import java.util.LinkedList;
import java.util.List;

public class ReteTest {

    private Knowledge buildAnimalKnowledge() {
        Knowledge knowledge = new KnowledgeImpl();
        knowledge.addKnowdlege("type", AnimalType.DOG);
        knowledge.addKnowdlege("color", Color.BLACK);
        knowledge.addKnowdlege("weight", 50);
        knowledge.addKnowdlege("age", 4);
        knowledge.addKnowdlege("size", Size.BIG);
        knowledge.addKnowdlege("hair", Hair.SHORT);

        return knowledge;
    }

    private List<Rule> buildRules(Knowledge knowledge) {
        List<Rule> rules = new LinkedList<Rule>();
        rules.add(new DogsHotnessRule());
        rules.add(new CatsHotnessRule());
        rules.add(new GiveFoodRule());
        rules.add(new AnimalHappinessRule());

        return rules;
    }

    @Test
    public void testForwardChain() {
        Knowledge animal = buildAnimalKnowledge();
        List<Rule> rules = new LinkedList<Rule>();
        rules.add(new DogsHotnessRule());
        ReteAlgorithm rete = new ForwardChain(rules, animal);
        rete.runReteAlgorithm();

        Assert.assertTrue(animal.hasKeyValue("heat", Amount.LOW));
    }

    @Test
    public void firingMultipleRulesForwardChain() {
        Knowledge animal = buildAnimalKnowledge();
        ReteAlgorithm rete = new ForwardChain(buildRules(animal), animal);
        rete.runReteAlgorithm();

        Assert.assertTrue(animal.hasKeyValue("heat", Amount.LOW) && animal.hasKeyValue("giveFood", true) && animal.hasKeyValue("happiness", Amount.HIGH));
    }

    @Test
    public void testBackwardChain() {
        Knowledge animal = buildAnimalKnowledge();
        ReteAlgorithm rete = new BackwardChain(buildRules(animal), animal, "happiness", Amount.HIGH);
        rete.runReteAlgorithm();

        Assert.assertTrue(animal.hasKeyValue("happiness", Amount.HIGH));
    }
}
