package rules.feedlot;

import condition.MoreThan;
import daos.Corral;
import rules.Rule;

public class FeedlotTemperatureHot extends Rule {

    public FeedlotTemperatureHot () {
        addPremise(Corral.TEMPERATURE.name(), new MoreThan(28));
        implications.put(Corral.FACTOR_MATERIA_SECA.name(), 0.95);
    }
}
