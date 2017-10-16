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

    private void testCustomFeedlotForward(int headCount, int day, double initialWeight, int temperature, FeedlotFood expectedFood) {
        Knowledge corral = KnowledgeCorralBuilder.buildCorralKnowledge(headCount, day, initialWeight, temperature);
        ReteAlgorithm rete = new ForwardChain(FeedlotRulesBuilder.build(corral), corral);
        rete.runReteAlgorithm();

        FeedlotFood feedlotFood = FoodBuilder.buildFeedlotFood(corral);

        Assert.assertTrue(feedlotFood.equals(expectedFood));
    }

    private FeedlotFood customExpectedFeedlotFood(double materiaSeca, double siloSorgo, double maiz,
                                                  double expellerSoja, double premezclaMineral, double humidity) {
        FeedlotFood food = new FeedlotFood();

        food.setMateriaSeca(materiaSeca);
        food.setSiloSorgo(siloSorgo);
        food.setMaiz(maiz);
        food.setExpellerSoja(expellerSoja);
        food.setPremezclaMineral(premezclaMineral);
        food.setHumidity(humidity);

        return food;
    }

    @Test
    public void testFeedlotDayOneHotForward() {
        testCustomFeedlotForward(30, 1, 220, 29,
                customExpectedFeedlotFood(62.7, 30.1, 23.83, 7.77, 1.0, 38.43));
    }

    @Test
    public void testFeedlotDayTenHotForward() {
        testCustomFeedlotForward(30, 10, 220, 30,
                customExpectedFeedlotFood(125.40, 60.19, 47.65, 15.55, 2.01, 76.86));
    }

    @Test
    public void testFeedlotDayTwentyColdForward() {
        testCustomFeedlotForward(30, 20, 220, 10,
                customExpectedFeedlotFood(207.90, 76.92, 101.87, 25.47, 3.64, 102.40));
    }

    @Test
    public void testFeedlotDayTwentyAverageForward() {
        testCustomFeedlotForward(30, 20, 220, 25,
                customExpectedFeedlotFood(198.00, 73.26, 97.02, 24.25, 3.47, 97.52));
    }

    @Test
    public void testFeedlotDayTwentyHotForward() {
        testCustomFeedlotForward(30, 20, 220, 30,
                customExpectedFeedlotFood(188.10, 69.60, 92.17, 23.04, 3.29, 92.65));
    }

    @Test
    public void testFeedlotDayFiftyColdForward() {
        testCustomFeedlotForward(30, 50, 220, 10,
                customExpectedFeedlotFood(228.38, 60.52, 136.57, 27.41, 3.88, 84.47));
    }

    @Test
    public void testFeedlotDayOneHotBackward() {
        Knowledge corral = KnowledgeCorralBuilder.buildCorralKnowledge(30, 1, 220, 29);
        List<Rule> rules = FeedlotRulesBuilder.build(corral);
        ReteAlgorithm rete = new BackwardChain(rules, corral, Corral.PORCENTAGE_WEIGHT_MATERIA_SECA.name(), 0.01);
        rete.runReteAlgorithm();

        Assert.assertTrue(corral.hasKeyValue(Corral.PORCENTAGE_WEIGHT_MATERIA_SECA.name(), 0.01));
    }
}
