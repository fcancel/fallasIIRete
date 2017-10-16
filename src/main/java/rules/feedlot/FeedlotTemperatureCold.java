package rules.feedlot;

import condition.LessThan;
import daos.Corral;
import rules.Rule;

public class FeedlotTemperatureCold extends Rule {

    public FeedlotTemperatureCold () {
        addPremise(Corral.TEMPERATURA.name(), new LessThan(20));
        implications.put(Corral.FACTOR_MATERIA_SECA.name(), 1.05);
    }
}
