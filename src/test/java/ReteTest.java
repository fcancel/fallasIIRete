import daos.Corral;
import daos.FeedlotFood;
import knowledge.Knowledge;
import knowledge.KnowledgeCorralBuilder;
import knowledge.KnowledgeImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import rete.BackwardChain;
import rete.ForwardChain;
import rete.ReteAlgorithm;
import rules.*;
import rules.animals.AnimalHappinessRule;
import rules.animals.CatsHotnessRule;
import rules.animals.DogsHotnessRule;
import rules.animals.GiveFoodRule;
import rules.feedlot.*;
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

    private List<Rule> buildRules() {
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
    public void testFiringMultipleRulesForwardChain() {
        Knowledge animal = buildAnimalKnowledge();
        ReteAlgorithm rete = new ForwardChain(buildRules(), animal);
        rete.runReteAlgorithm();

        Assert.assertTrue(animal.hasKeyValue("heat", Amount.LOW) && animal.hasKeyValue("giveFood", true) && animal.hasKeyValue("happiness", Amount.HIGH));
    }

    @Test
    public void testBackwardChain() {
        Knowledge animal = buildAnimalKnowledge();
        ReteAlgorithm rete = new BackwardChain(buildRules(), animal, "happiness", Amount.HIGH);
        rete.runReteAlgorithm();

        Assert.assertTrue(animal.hasKeyValue("happiness", Amount.HIGH));
    }

    @Test
    public void testFeedlotDiaUnoCalurosoForward() {
        Knowledge corral = KnowledgeCorralBuilder.buildCorralKnowledge(30, 1, 220, 29);
        List<Rule> rules = buildFeedlotRules(corral);
        ReteAlgorithm rete = new ForwardChain(rules, corral);
        rete.runReteAlgorithm();

        FeedlotFood feedlotFood = FoodBuilder.buildFeedlotFood(corral);
        FeedlotFood expectedFeedlotFood = createExpectedFeedlotFood();

        Assert.assertTrue(feedlotFood.equals(expectedFeedlotFood));
    }

    private FeedlotFood createExpectedFeedlotFood() {
        FeedlotFood food = new FeedlotFood();

        food.setMateriaSeca(62.7);
        food.setSiloSorgo(30.1);
        food.setMaiz(23.83);
        food.setExpellerSoja(7.77);
        food.setPremezclaMineral(1.0);
        food.setHumidity(38.43);

        return food;
    }

    private List<Rule> buildFeedlotRules(Knowledge corral) {
        List<Rule> rules = new LinkedList<Rule>();
        rules.add(new FeedlotAdaptionFirstDays());
        rules.add(new FeedlotAdaptionEarlyDays());
        rules.add(new FeedlotAdaptionMiddleDays());
        rules.add(new FeedlotAdaptionLateDays());
        rules.add(new FeedlotPercentagesEarlyDays());
        rules.add(new FeedlotPercentagesMiddleDays());
        rules.add(new FeedlotPercentagesLateDays());
        rules.add(new FeedlotGainWeight(corral));
        rules.add(new FeedlotTemperatureCold());
        rules.add(new FeedlotTemperatureHot());
        rules.add(new FeedlotTemperatureAverage());

        return rules;
    }
}
