package rules;

import condition.BiggerThan;
import condition.Equal;
import utils.Size;

public class GiveFoodRule extends Rule {

    public GiveFoodRule() {
        premises.put("weight", new BiggerThan(20));
        premises.put("size", new Equal(Size.BIG));
        implications.put("giveFood", true);
    }
}
