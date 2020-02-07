package by.training.task1.repository;

import by.training.task1.entity.Sweetness;
import by.training.task1.exception.RepositoryException;
import by.training.task1.specification.SweetnessSpecification;

import java.util.Set;

public interface PresentRepository {

    void addSweetness(Sweetness sweetness) throws RepositoryException;

    void deleteSweetness(Sweetness sweetness) throws RepositoryException;

    Sweetness getSweetness(Sweetness sweetness) throws RepositoryException;

    Set<Sweetness> getPresent();

    Set<Sweetness> query(SweetnessSpecification specification);
}
