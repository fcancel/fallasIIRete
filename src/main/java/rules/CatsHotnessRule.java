package rules;

import condition.Equal;
import knowledge.Animal;
import knowledge.Knowledge;
import utils.Amount;
import utils.AnimalType;
import utils.Hair;

public class CatsHotnessRule extends Rule {

    public CatsHotnessRule() {
        premises.put("type", new Equal(AnimalType.CAT));
        premises.put("hair",new Equal(Hair.SHORT));
        implications.put("heat", Amount.MEDIUM);
    }
}
