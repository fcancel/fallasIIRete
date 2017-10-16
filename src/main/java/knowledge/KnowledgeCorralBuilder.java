package knowledge;

import daos.Corral;

public class KnowledgeCorralBuilder {

    private KnowledgeCorralBuilder () {}

    public static Knowledge buildCorralKnowledge(int cabezas, int dia, double pesoInicial, int temperatura) {
        Knowledge corral = new KnowledgeImpl();
        corral.addKnowdlege(Corral.CABEZAS.name(), cabezas);
        corral.addKnowdlege(Corral.DIA.name(), dia);
        corral.addKnowdlege(Corral.PESO_INICIAL.name(), pesoInicial);
        corral.addKnowdlege(Corral.PESO_ACTUAL.name(), pesoInicial);
        corral.addKnowdlege(Corral.TEMPERATURA.name(), temperatura);

        return corral;
    }
}
