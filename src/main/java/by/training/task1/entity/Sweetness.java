package by.training.task1.entity;

import java.util.Objects;

public abstract class Sweetness {
    protected static int entityNumber = 0;
    protected int id;
    protected double weight;
    protected double sugarContent;

    private static final double DEFAULT_WEIGHT = 0.01;
    private static final double DEFAULT_SUGAR_CONTENT = 4.5;

    public Sweetness() {
        this.id = ++entityNumber;
        this.weight = DEFAULT_WEIGHT;
        this.sugarContent = DEFAULT_SUGAR_CONTENT;
    }

    public Sweetness(double weight, double sugarContent) {
        this.id = ++entityNumber;
        this.weight = weight;
        this.sugarContent = sugarContent;
    }

    public Sweetness(Sweetness sweetness) {
        this.id = ++entityNumber;
        this.sugarContent = sweetness.sugarContent;
        this.weight = sweetness.weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSugarContent() {
        return sugarContent;
    }

    public void setSugarContent(double sugarContent) {
        this.sugarContent = sugarContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweetness sweetness = (Sweetness) o;
        return Double.compare(sweetness.weight, weight) == 0 &&
                Double.compare(sweetness.sugarContent, sugarContent) == 0;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hash = 1;
        hash = hash * prime + id;
        hash = hash * prime + Double.hashCode(weight);
        hash = hash * prime + Double.hashCode(sugarContent);
        return hash;
    }

    @Override
    public String toString() {
        return "Sweetness{" +
                "id=" + id +
                ", weight=" + weight +
                ", sugarContent=" + sugarContent +
                '}';
    }
}
