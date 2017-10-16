package rules.feedlot;

import condition.LessThan;
import condition.MoreThan;
import daos.Corral;
import rules.Rule;

public class FeedlotAdaptionEarlyDays extends Rule {

    public FeedlotAdaptionEarlyDays () {
        addPremise(Corral.DAY.name(), new MoreThan(5));
        addPremise(Corral.DAY.name(), new LessThan(15));
        implications.put(Corral.PORCENTAGE_WEIGHT_MATERIA_SECA.name(), 0.02);
    }
}
