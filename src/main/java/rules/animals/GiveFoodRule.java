package rules.animals;

import condition.MoreThan;
import condition.Equal;
import rules.Rule;
import utils.Size;

public class GiveFoodRule extends Rule {

    public GiveFoodRule() {
        addPremise("weight", new MoreThan(20));
        addPremise("size", new Equal(Size.BIG));
        implications.put("giveFood", true);
    }
}
