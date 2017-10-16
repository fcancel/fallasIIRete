package rules.feedlot;

import condition.LessThan;
import condition.MoreThan;
import daos.Corral;
import rules.Rule;

public class FeedlotAdaptionMiddleDays extends Rule {

    public FeedlotAdaptionMiddleDays () {
        addPremise(Corral.DAY.name(), new MoreThan(14));
        addPremise(Corral.DAY.name(), new LessThan(26));
        implications.put(Corral.PORCENTAGE_WEIGHT_MATERIA_SECA.name(), 0.03);
    }
}
