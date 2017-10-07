import daos.Animal;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import rete.ForwardChain;
import rete.ReteAlgorithm;
import rules.*;
import utils.*;

import java.util.LinkedList;
import java.util.List;

public class ReteTest {

    private Animal buildAnimal() {
        Animal animal = new Animal();
        animal.setType(AnimalType.DOG);
        animal.setColor(Color.BLACK);
        animal.setWeight(50);
        animal.setAge(4);
        animal.setSize(Size.BIG);
        animal.setHair(Hair.SHORT);

        return animal;
    }

    @Test
    public void testForwardChain() {
        Animal animal = buildAnimal();
        List<Rule> rules = new LinkedList<Rule>();
        rules.add(new DogsHotnessRule(animal));
        ReteAlgorithm rete = new ForwardChain(rules);
        rete.runReteAlgorithm();

        Assert.assertTrue(animal.getHeat() == Amount.LOW);
    }

    @Test
    public void firingMultipleRulesForwardChain() {
        Animal animal = buildAnimal();
        List<Rule> rules = new LinkedList<Rule>();
        rules.add(new DogsHotnessRule(animal));
        rules.add(new CatsHotnessRule(animal));
        rules.add(new GiveFoodRule(animal));
        rules.add(new AnimalHappinessRule(animal));
        ReteAlgorithm rete = new ForwardChain(rules);
        rete.runReteAlgorithm();

        Assert.assertTrue(animal.getHeat() == Amount.LOW && animal.getGiveFood() == true && animal.getHappiness() ==Amount.HIGH);
    }
}
