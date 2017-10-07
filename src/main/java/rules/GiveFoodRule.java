package rules;

import daos.Animal;
import utils.Size;

public class GiveFoodRule implements Rule {
    private final Animal animal;

    public GiveFoodRule(Animal animal) {
        this.animal = animal;
    }

    @Override
    public Boolean meetsConditions() {
        return (animal.getWeight() > 20 && animal.getSize() == Size.BIG);
    }

    @Override
    public void fireRule() {
        animal.setGiveFood(true);
    }
}
