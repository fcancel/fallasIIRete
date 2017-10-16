package rules.feedlot;

import condition.LessThan;
import condition.MoreThan;
import daos.Corral;
import rules.Rule;

public class FeedlotAdaptionMiddleDays extends Rule {

    public FeedlotAdaptionMiddleDays () {
        addPremise(Corral.DIA.name(), new MoreThan(14));
        addPremise(Corral.DIA.name(), new LessThan(26));
        implications.put(Corral.PORCENTAJE_PESO_MATERIA_SECA.name(), 0.03);
    }
}
