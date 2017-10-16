package rules.feedlot;

import knowledge.Knowledge;
import rules.Rule;

import java.util.LinkedList;
import java.util.List;

public class FeedlotRulesBuilder {

    private FeedlotRulesBuilder () {}

    public static List<Rule> build(Knowledge corral) {
        List<Rule> rules = new LinkedList<>();
        rules.add(new FeedlotAdaptionFirstDays());
        rules.add(new FeedlotAdaptionEarlyDays());
        rules.add(new FeedlotAdaptionMiddleDays());
        rules.add(new FeedlotAdaptionLateDays());
        rules.add(new FeedlotPercentagesEarlyDays());
        rules.add(new FeedlotPercentagesMiddleDays());
        rules.add(new FeedlotPercentagesLateDays());
        rules.add(new FeedlotGainWeight(corral));
        rules.add(new FeedlotTemperatureCold());
        rules.add(new FeedlotTemperatureHot());
        rules.add(new FeedlotTemperatureAverage());

        return rules;
    }
}
