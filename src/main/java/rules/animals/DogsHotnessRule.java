package rules.animals;

import condition.Equal;
import rules.Rule;
import utils.Amount;
import utils.AnimalType;
import utils.Hair;

public class DogsHotnessRule extends Rule {
    public DogsHotnessRule() {
        addPremise("type", new Equal(AnimalType.DOG));
        addPremise("hair", new Equal(Hair.SHORT));
        implications.put("heat", Amount.LOW);

    }
}
