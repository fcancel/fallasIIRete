package rules;

import daos.Animal;
import utils.Amount;

public class AnimalHappinessRule implements Rule {
    private final Animal animal;

    public AnimalHappinessRule(Animal animal) {
        this.animal = animal;
    }

    @Override
    public Boolean meetsConditions() {
        return (animal.getGiveFood() == true);
    }

    @Override
    public void fireRule() {
        animal.setHappiness(Amount.HIGH);
    }
}
