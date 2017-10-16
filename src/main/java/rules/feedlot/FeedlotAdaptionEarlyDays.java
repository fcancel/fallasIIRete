package rules.feedlot;

import condition.LessThan;
import condition.MoreThan;
import daos.Corral;
import rules.Rule;

public class FeedlotAdaptionEarlyDays extends Rule {

    public FeedlotAdaptionEarlyDays () {
        addPremise(Corral.DIA.name(), new MoreThan(5));
        addPremise(Corral.DIA.name(), new LessThan(15));
        implications.put(Corral.PORCENTAJE_PESO_MATERIA_SECA.name(), 0.02);
    }
}
