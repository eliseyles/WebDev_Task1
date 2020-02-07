package by.training.task1.comparator;

import by.training.task1.entity.Sweetness;

import java.util.Comparator;

public class SweetnessComparatorByWeight implements Comparator<Sweetness> {

    @Override
    public int compare(Sweetness o1, Sweetness o2) {
        return Double.compare(o1.getWeight(), o2.getWeight());
    }
}
