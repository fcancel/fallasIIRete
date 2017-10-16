package rules.feedlot;

import condition.LessThan;
import condition.MoreThan;
import daos.Corral;
import rules.Rule;

public class FeedlotPercentagesEarlyDays extends Rule {

    public FeedlotPercentagesEarlyDays () {
        addPremise(Corral.DIA.name(), new LessThan(11));
        implications.put(Corral.ALIMENTO_SILO_SORGO.name(), 0.48);
        implications.put(Corral.ALIMENTO_MAIZ.name(), 0.38);
        implications.put(Corral.ALIMENTO_EXPELLER_SOJA.name(), 0.124);
        implications.put(Corral.ALIMENTO_PREMEZCLA_MINERAL.name(), 0.016);
        implications.put(Corral.ALIMENTO_MATERIA_SECA.name(), 0.62);
    }
}
