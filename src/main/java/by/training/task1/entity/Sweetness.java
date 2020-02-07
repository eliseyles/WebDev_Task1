package by.training.task1.entity;

import java.util.Objects;

public abstract class Sweetness {
    protected double weight;
    protected double cost;
    protected double sugarContent;

    private static final double DEFAULT_COST = 1.00;
    private static final double DEFAULT_WEIGHT = 0.01;
    private static final double DEFAULT_SUGAR_CONTENT = 4.5;

    public Sweetness() {
        this.cost = DEFAULT_COST;
        this.weight = DEFAULT_WEIGHT;
        this.sugarContent = DEFAULT_SUGAR_CONTENT;
    }

    public Sweetness(double weight, double cost, double sugarContent) {
        this.weight = weight;
        this.cost = cost;
        this.sugarContent = sugarContent;
    }

    public Sweetness(Sweetness sweetness) {
        this.cost = sweetness.cost;
        this.sugarContent = sweetness.sugarContent;
        this.weight = sweetness.weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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
                Double.compare(sweetness.cost, cost) == 0 &&
                Double.compare(sweetness.sugarContent, sugarContent) == 0;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hash = 1;
        hash = hash * prime + Double.hashCode(cost);
        hash = hash * prime + Double.hashCode(weight);
        hash = hash * prime + Double.hashCode(sugarContent);
        return hash;
    }

    @Override
    public String toString() {
        return "Sweetness{" +
                "weight=" + weight +
                ", cost=" + cost +
                ", sugarContent=" + sugarContent +
                '}';
    }
}
