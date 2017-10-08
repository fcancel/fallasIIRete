package rules;

import condition.Equal;
import utils.Amount;

public class AnimalHappinessRule extends Rule {
    public AnimalHappinessRule() {
        premises.put("giveFood", new Equal(true));
        implications.put("happiness", Amount.HIGH);
    }
}
