package rules.feedlot;

import condition.MoreThan;
import daos.Corral;
import rules.Rule;

public class FeedlotPercentagesLateDays extends Rule {

    public FeedlotPercentagesLateDays () {
        addPremise(Corral.DIA.name(), new MoreThan(21));
        implications.put(Corral.ALIMENTO_SILO_SORGO.name(), 0.265);
        implications.put(Corral.ALIMENTO_MAIZ.name(), 0.598);
        implications.put(Corral.ALIMENTO_EXPELLER_SOJA.name(), 0.12);
        implications.put(Corral.ALIMENTO_PREMEZCLA_MINERAL.name(), 0.017);
        implications.put(Corral.ALIMENTO_MATERIA_SECA.name(), 0.73);
    }
}
