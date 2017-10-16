package rules.feedlot;

import condition.MoreThan;
import daos.Corral;
import rules.Rule;

public class FeedlotPercentagesLateDays extends Rule {

    public FeedlotPercentagesLateDays () {
        addPremise(Corral.DAY.name(), new MoreThan(21));
        implications.put(Corral.FOOD_SILO_SORGO.name(), 0.265);
        implications.put(Corral.FOOD_MAIZ.name(), 0.598);
        implications.put(Corral.FOOD_EXPELLER_SOJA.name(), 0.12);
        implications.put(Corral.FOOD_PREMEZCLA_MINERAL.name(), 0.017);
        implications.put(Corral.FOOD_MATERIA_SECA.name(), 0.73);
    }
}
