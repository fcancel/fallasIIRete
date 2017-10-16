package rules.feedlot;

import condition.LessThan;
import daos.Corral;
import rules.Rule;

public class FeedlotAdaptionFirstDays extends Rule {

    public FeedlotAdaptionFirstDays () {
        addPremise(Corral.DAY.name(), new LessThan(6));
        implications.put(Corral.PORCENTAGE_WEIGHT_MATERIA_SECA.name(), 0.01);
    }
}
