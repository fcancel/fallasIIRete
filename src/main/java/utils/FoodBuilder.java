package utils;

import daos.Corral;
import daos.FeedlotFood;
import knowledge.Knowledge;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FoodBuilder {
    private FoodBuilder() {}

    public static FeedlotFood buildFeedlotFood(Knowledge knowledge) {
        FeedlotFood feedlotFood = new FeedlotFood();

        feedlotFood.setMateriaSeca(calculateMateriaSeca(knowledge));
        feedlotFood.setSiloSorgo(calculateSiloSorgo(knowledge));
        feedlotFood.setMaiz(calculateMaiz(knowledge));
        feedlotFood.setExpellerSoja(calculateExpellerSoja(knowledge));
        feedlotFood.setPremezclaMineral(calculatePremezclaMineral (knowledge));
        feedlotFood.setHumidity(calculateHumidity(knowledge));

        return feedlotFood;
    }

    private static double calculateHumidity(Knowledge knowledge) {
        double value = ((1 -(double) knowledge.getValue(Corral.FOOD_MATERIA_SECA.name())) * calculateMateriaSeca(knowledge)/(double) knowledge.getValue(Corral.FOOD_MATERIA_SECA.name()));

        return round(value);
    }

    private static double calculatePremezclaMineral(Knowledge knowledge) {
        double value = ((double) knowledge.getValue(Corral.FOOD_PREMEZCLA_MINERAL.name())) * calculateMateriaSeca(knowledge);

        return round(value);
    }

    private static double calculateExpellerSoja(Knowledge knowledge) {
        double value = ((double) knowledge.getValue(Corral.FOOD_EXPELLER_SOJA.name())) * calculateMateriaSeca(knowledge);

        return round(value);
    }

    private static double calculateMaiz(Knowledge knowledge) {
        double value = ((double) knowledge.getValue(Corral.FOOD_MAIZ.name())) * calculateMateriaSeca(knowledge);

        return round(value);
    }

    private static double calculateSiloSorgo(Knowledge knowledge) {
        double value = ((double) knowledge.getValue(Corral.FOOD_SILO_SORGO.name())) * calculateMateriaSeca(knowledge);

        return round(value);
    }

    private static double calculateMateriaSeca(Knowledge knowledge) {

        double value = ((double) knowledge.getValue(Corral.ACTUAL_WEIGHT.name())) *
                ((double) knowledge.getValue(Corral.PORCENTAGE_WEIGHT_MATERIA_SECA.name())) *
                ((double) ((Integer)knowledge.getValue(Corral.HEAD_COUNT.name()))) *
                ((double) knowledge.getValue(Corral.FACTOR_MATERIA_SECA.name()));

        return round(value);
    }


    public static double round(double value) {
        int places = 2;
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
