package rules.feedlot;

import condition.LessThan;
import daos.Corral;
import rules.Rule;

public class FeedlotPercentagesEarlyDays extends Rule {

    public FeedlotPercentagesEarlyDays () {
        addPremise(Corral.DAY.name(), new LessThan(11));
        implications.put(Corral.FOOD_SILO_SORGO.name(), 0.48);
        implications.put(Corral.FOOD_MAIZ.name(), 0.38);
        implications.put(Corral.FOOD_EXPELLER_SOJA.name(), 0.124);
        implications.put(Corral.FOOD_PREMEZCLA_MINERAL.name(), 0.016);
        implications.put(Corral.FOOD_MATERIA_SECA.name(), 0.62);
    }
}
