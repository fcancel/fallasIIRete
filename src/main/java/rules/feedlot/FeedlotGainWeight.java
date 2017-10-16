package rules.feedlot;

import condition.MoreThan;
import daos.Corral;
import knowledge.Knowledge;
import rules.Rule;

public class FeedlotGainWeight extends Rule {

    public FeedlotGainWeight (Knowledge corral) {
        addPremise(Corral.DAY.name(), new MoreThan(25));
        double pesoActual = (double)corral.getValue(Corral.INITIAL_WEIGHT.name()) + ((double)((Integer) corral.getValue(Corral.DAY.name())) -25.0) * 1.2;
        implications.put(Corral.ACTUAL_WEIGHT.name(), pesoActual);
    }
}
