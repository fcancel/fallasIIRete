package rules.feedlot;

import condition.LessThan;
import condition.MoreThan;
import daos.Corral;
import rules.Rule;

public class FeedlotPercentagesMiddleDays extends Rule {

    public FeedlotPercentagesMiddleDays () {
        addPremise(Corral.DIA.name(), new MoreThan(10));
        addPremise(Corral.DIA.name(), new LessThan(22));
        implications.put(Corral.ALIMENTO_SILO_SORGO.name(), 0.37);
        implications.put(Corral.ALIMENTO_MAIZ.name(), 0.49);
        implications.put(Corral.ALIMENTO_EXPELLER_SOJA.name(), 0.1225);
        implications.put(Corral.ALIMENTO_PREMEZCLA_MINERAL.name(), 0.0175);
        implications.put(Corral.ALIMENTO_MATERIA_SECA.name(), 0.67);
    }
}
