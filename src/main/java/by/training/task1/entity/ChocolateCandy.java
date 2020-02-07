package by.training.task1.entity;

import java.util.Objects;

public class ChocolateCandy extends Sweetness {
    private ChocolateType chocolateType;

    private static final ChocolateType DEFAULT_CHOCOLATE_TYPE = ChocolateType.MILK;

    public ChocolateCandy() {
        super();
        this.chocolateType = DEFAULT_CHOCOLATE_TYPE;
    }

    public ChocolateCandy(double weight, double sugarContent, ChocolateType chocolateType) {
        super(weight, sugarContent);
        this.chocolateType = chocolateType;
    }

    public ChocolateCandy(ChocolateCandy chocolateCandy) {
        super(chocolateCandy);
        this.chocolateType = chocolateCandy.chocolateType;
    }

    public ChocolateType getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(ChocolateType chocolateType) {
        this.chocolateType = chocolateType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChocolateCandy that = (ChocolateCandy) o;
        return chocolateType == that.chocolateType;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hash = super.hashCode();
        hash = hash * prime + chocolateType.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        return "ChocolateCandy{" +
                "weight=" + weight +
                ", sugarContent=" + sugarContent +
                "chocolateType=" + chocolateType +
                '}';
    }
}
