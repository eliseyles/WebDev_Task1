package by.training.task1.repository;

import by.training.task1.entity.Sweetness;
import by.training.task1.specification.SweetnessSpecification;

import java.util.Set;

public interface PresentRepository {

    void addSweetness(Sweetness sweetness);

    void deleteSweetness(Sweetness sweetness);

    Set query(SweetnessSpecification specification);
}
