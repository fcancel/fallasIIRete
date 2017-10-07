package rules;

import daos.Animal;
import utils.Amount;
import utils.AnimalType;
import utils.Hair;

public class CatsHotnessRule implements Rule {
    private final Animal animal;

    public CatsHotnessRule(Animal animal) {
        this.animal = animal;
    }

    @Override
    public Boolean meetsConditions() {
        return (animal.getType() == AnimalType.CAT && animal.getHair() == Hair.SHORT);
    }

    @Override
    public void fireRule() {
        animal.setHeat(Amount.MEDIUM);
    }
}
