package rules;

import daos.Animal;
import utils.Amount;
import utils.AnimalType;
import utils.Hair;

public class DogsHotnessRule implements Rule {
    Animal animal;

    public DogsHotnessRule(Animal animal) {
        this.animal = animal;
    }

    public Boolean meetsConditions() {
        return (animal.getType() == AnimalType.DOG && animal.getHair() == Hair.SHORT);
    }

    public void fireRule() {
        animal.setHeat(Amount.LOW);
    }
}
