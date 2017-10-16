package utils;

import daos.FeedlotFood;

public class FeedlotPrinter {
    public static void prettyPrint(FeedlotFood feedlotFood) {
        System.out.println("La racion en MS de hoy es de " + feedlotFood.getMateriaSeca() + " kg");
        System.out.println("Dividida en: ");
        System.out.println("Silo Sorgo " + feedlotFood.getSiloSorgo() + " kg");
        System.out.println("Maiz " + feedlotFood.getMaiz() + " kg");
        System.out.println("Expeller de Soja " + feedlotFood.getExpellerSoja() + " kg");
        System.out.println("Premezcla Mineral " + feedlotFood.getPremezclaMineral() + " kg");
        System.out.println("A la materia seca hay que agregarle " + feedlotFood.getHumidity() + " litros " + "de agua");
    }
}
