package daos;

public class FeedlotFood {
    private double materiaSeca;
    private double siloSorgo;
    private double maiz;
    private double expellerSoja;
    private double premezclaMineral;
    private double humidity;

    public void setMateriaSeca(double materiaSeca) {
        this.materiaSeca = materiaSeca;
    }

    public void setSiloSorgo(double siloSorgo) {
        this.siloSorgo = siloSorgo;
    }

    public void setMaiz(double maiz) {
        this.maiz = maiz;
    }

    public void setExpellerSoja(double expellerSoja) {
        this.expellerSoja = expellerSoja;
    }

    public void setPremezclaMineral(double premezclaMineral) {
        this.premezclaMineral = premezclaMineral;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    @Override
    public boolean equals (Object object)
    {
        if (this==object) return true;
        if (this == null) return false;
        if (this.getClass() != object.getClass()) return false;
        FeedlotFood food = (FeedlotFood) object ;
        return (this.materiaSeca == food.getMateriaSeca()) &&
                (this.siloSorgo == food.getSiloSorgo()) &&
                (this.maiz == food.getMaiz()) &&
                (this.expellerSoja == food.getExpellerSoja()) &&
                (this.premezclaMineral == food.getPremezclaMineral()) &&
                (this.humidity == food.getHumidity());
    }

    public double getMateriaSeca() {
        return materiaSeca;
    }

    public double getSiloSorgo() {
        return siloSorgo;
    }

    public double getMaiz() {
        return maiz;
    }

    public double getExpellerSoja() {
        return expellerSoja;
    }

    public double getPremezclaMineral() {
        return premezclaMineral;
    }

    public double getHumidity() {
        return humidity;
    }
}
