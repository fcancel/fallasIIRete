package rules.feedlot;

import condition.MoreThan;
import daos.Corral;
import rules.Rule;

public class FeedlotAdaptionLateDays extends Rule {

    public FeedlotAdaptionLateDays () {
        addPremise(Corral.DIA.name(), new MoreThan(26));
        implications.put(Corral.PORCENTAJE_PESO_MATERIA_SECA.name(), 0.029);
    }
}
