import daos.FeedlotFood;
import knowledge.Knowledge;
import knowledge.KnowledgeCorralBuilder;
import rete.ForwardChain;
import rete.ReteAlgorithm;
import rules.feedlot.FeedlotRulesBuilder;
import utils.FeedlotPrinter;
import utils.FoodBuilder;

public class Main {

    public static void main(String[] args) {
        Knowledge corral = KnowledgeCorralBuilder.buildCorralKnowledge(30, 10, 180, 25);
        ReteAlgorithm rete = new ForwardChain(FeedlotRulesBuilder.build(corral), corral);
        rete.runReteAlgorithm();

        FeedlotFood feedlotFood = FoodBuilder.buildFeedlotFood(corral);

        FeedlotPrinter.prettyPrint(feedlotFood);
    }
}
