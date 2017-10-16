package rules.animals;

import condition.Equal;
import knowledge.Animal;
import knowledge.Knowledge;
import rules.Rule;
import utils.Amount;
import utils.AnimalType;
import utils.Hair;

public class CatsHotnessRule extends Rule {

    public CatsHotnessRule() {
        addPremise("type", new Equal(AnimalType.CAT));
        addPremise("hair",new Equal(Hair.SHORT));
        implications.put("heat", Amount.MEDIUM);
    }
}
