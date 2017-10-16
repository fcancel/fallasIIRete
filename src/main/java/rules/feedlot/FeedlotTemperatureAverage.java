package rules.feedlot;

import condition.LessThan;
import condition.MoreThan;
import daos.Corral;
import rules.Rule;

public class FeedlotTemperatureAverage extends Rule {

    public FeedlotTemperatureAverage () {
        addPremise(Corral.TEMPERATURE.name(), new MoreThan(19));
        addPremise(Corral.TEMPERATURE.name(), new LessThan(29));
        implications.put(Corral.FACTOR_MATERIA_SECA.name(), 1.00);
    }
}
