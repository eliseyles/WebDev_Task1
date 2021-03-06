package by.training.task1.specification.impl;

import by.training.task1.entity.CaramelCandy;
import by.training.task1.entity.Sweetness;
import by.training.task1.repository.PresentRepository;
import by.training.task1.repository.impl.PresentRepositoryImpl;
import by.training.task1.specification.SweetnessSpecification;

import java.util.HashSet;
import java.util.Set;

public class GetAllCaramelCandySpecification implements SweetnessSpecification {
    @Override
    public Set<Sweetness> specify() {
        Set<Sweetness> result = new HashSet<>();
        Set<Sweetness> present = PresentRepositoryImpl.INSTANCE.getPresent();
        for (Sweetness sweetness : present) {
            if (sweetness.getClass() == CaramelCandy.class) {
                result.add(sweetness);
            }
        }
        return result;
    }
}
