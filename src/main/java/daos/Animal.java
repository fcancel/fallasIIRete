package daos;

import utils.*;

public class Animal {
    private AnimalType type;
    private Color color;
    private Integer weight;
    private Integer age;
    private Size size;
    private Hair hair;
    private Amount heat;
    private boolean giveFood;
    private Amount happiness;

    public void setType(AnimalType type) {
        this.type = type;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setHair(Hair hair) {
        this.hair = hair;
    }

    public Amount getHeat() {
        return heat;
    }

    public Hair getHair() {
        return hair;
    }

    public void setHeat(Amount heat) {
        this.heat = heat;
    }

    public AnimalType getType() {
        return type;
    }

    public Integer getWeight() {
        return weight;
    }

    public Size getSize() {
        return size;
    }

    public void setGiveFood(boolean giveFood) {
        this.giveFood = giveFood;
    }

    public void setHappiness(Amount happiness) {
        this.happiness = happiness;
    }

    public Boolean getGiveFood() {
        return giveFood;
    }

    public Amount getHappiness() {
        return happiness;
    }
}
