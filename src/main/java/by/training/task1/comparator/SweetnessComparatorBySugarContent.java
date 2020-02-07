package by.training.task1.comparator;

import by.training.task1.entity.Sweetness;

import java.util.Comparator;

public class SweetnessComparatorBySugarContent implements Comparator<Sweetness> {
    @Override
    public int compare(Sweetness o1, Sweetness o2) {
        return Double.compare(o1.getSugarContent(), o2.getSugarContent());
    }
}
