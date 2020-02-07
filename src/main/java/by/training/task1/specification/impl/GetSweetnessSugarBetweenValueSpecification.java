package by.training.task1.specification.impl;

import by.training.task1.entity.ChocolateCandy;
import by.training.task1.entity.Sweetness;
import by.training.task1.repository.impl.PresentRepositoryImpl;
import by.training.task1.specification.SweetnessSpecification;

import java.util.HashSet;
import java.util.Set;

public class GetSweetnessSugarBetweenValueSpecification implements SweetnessSpecification {

    private double minValue;
    private double maxValue;

    public GetSweetnessSugarBetweenValueSpecification(double minValue, double maxValue) {
        if (minValue < maxValue) {
            this.minValue = minValue;
            this.maxValue = maxValue;
        } else {
            this.minValue = maxValue;
            this.maxValue = minValue;
        }
    }

    @Override
    public Set<Sweetness> specify() {
        Set<Sweetness> result = new HashSet<>();
        Set<Sweetness> present = PresentRepositoryImpl.INSTANCE.getPresent();
        for (Sweetness sweetness : present) {
            if (sweetness.getSugarContent() > minValue && sweetness.getSugarContent() < maxValue) {
                result.add(sweetness);
            }
        }
        return result;
    }
}
