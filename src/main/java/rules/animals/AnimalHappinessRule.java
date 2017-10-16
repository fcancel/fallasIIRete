package rules.animals;

import condition.Equal;
import rules.Rule;
import utils.Amount;

public class AnimalHappinessRule extends Rule {
    public AnimalHappinessRule() {
        addPremise("giveFood", new Equal(true));
        implications.put("happiness", Amount.HIGH);
    }
}
