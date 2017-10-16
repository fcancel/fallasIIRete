package rules.feedlot;

import condition.MoreThan;
import daos.Corral;
import rules.Rule;

public class FeedlotAdaptionLateDays extends Rule {

    public FeedlotAdaptionLateDays () {
        addPremise(Corral.DAY.name(), new MoreThan(26));
        implications.put(Corral.PORCENTAGE_WEIGHT_MATERIA_SECA.name(), 0.029);
    }
}
