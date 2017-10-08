package rules;

import condition.Equal;
import utils.Amount;
import utils.AnimalType;
import utils.Hair;

public class DogsHotnessRule extends Rule {
    public DogsHotnessRule() {
        premises.put("type", new Equal(AnimalType.DOG));
        premises.put("hair", new Equal(Hair.SHORT));
        implications.put("heat", Amount.LOW);

    }
}
