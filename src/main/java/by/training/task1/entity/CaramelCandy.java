package by.training.task1.entity;

import java.util.Objects;

public class CaramelCandy extends Sweetness{
    private FlavourType flavor;

    private static final FlavourType DEFAULT_FLAVOR = FlavourType.GRAPE;

    public CaramelCandy() {
        super();
        this.flavor = DEFAULT_FLAVOR;
    }

    public CaramelCandy(double weight, double sugarContent, FlavourType flavor) {
        super(weight, sugarContent);
        this.flavor = flavor;
    }

    public CaramelCandy(CaramelCandy caramelCandy) {
        super(caramelCandy);
        this.flavor = caramelCandy.flavor;
    }

    public FlavourType getFlavor() {
        return flavor;
    }

    public void setFlavor(FlavourType flavor) {
        this.flavor = flavor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CaramelCandy that = (CaramelCandy) o;
        return flavor == that.flavor;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hash = super.hashCode();
        hash = hash * prime + flavor.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        return "CaramelCandy{" +
                "id=" + id +
                ", weight=" + weight +
                ", sugarContent=" + sugarContent +
                ", flavor=" + flavor +
                '}';
    }
}
