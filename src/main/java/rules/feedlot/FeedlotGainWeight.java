package rules.feedlot;

import condition.MoreThan;
import daos.Corral;
import knowledge.Knowledge;
import rules.Rule;

public class FeedlotGainWeight extends Rule {

    public FeedlotGainWeight (Knowledge corral) {
        addPremise(Corral.DIA.name(), new MoreThan(25));
        double pesoActual = (double)corral.getValue(Corral.PESO_INICIAL.name()) + ((double)((Integer) corral.getValue(Corral.DIA.name())) -25.0) * 1.2;
        implications.put(Corral.PESO_ACTUAL.name(), pesoActual);
    }
}
