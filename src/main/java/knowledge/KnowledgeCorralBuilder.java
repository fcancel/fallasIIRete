package knowledge;

import daos.Corral;

public class KnowledgeCorralBuilder {

    private KnowledgeCorralBuilder () {}

    public static Knowledge buildCorralKnowledge(int headCount, int day, double initialWeight, int temperature) {
        Knowledge corral = new KnowledgeImpl();
        corral.addKnowdlege(Corral.HEAD_COUNT.name(), headCount);
        corral.addKnowdlege(Corral.DAY.name(), day);
        corral.addKnowdlege(Corral.INITIAL_WEIGHT.name(), initialWeight);
        corral.addKnowdlege(Corral.ACTUAL_WEIGHT.name(), initialWeight);
        corral.addKnowdlege(Corral.TEMPERATURE.name(), temperature);

        return corral;
    }
}
