package by.training.task1.repository.impl;

import by.training.task1.entity.CaramelCandy;
import by.training.task1.entity.Sweetness;
import by.training.task1.exception.IncorrectValueException;
import by.training.task1.exception.RepositoryException;
import by.training.task1.repository.PresentRepository;
import by.training.task1.specification.SweetnessSpecification;
import by.training.task1.validation.SweetnessValidator;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public enum PresentRepositoryImpl implements PresentRepository {
    INSTANCE;
    Logger logger = Logger.getLogger(PresentRepositoryImpl.class);
    Set<Sweetness> present = new HashSet<>();

    @Override
    public void addSweetness(Sweetness sweetness) throws RepositoryException {
        try {
            SweetnessValidator.isNull(sweetness);
            present.add(sweetness);
        } catch (IncorrectValueException e) {
            logger.warn("Object to add is null");
            throw new RepositoryException("Invalid object type");
        }
    }

    @Override
    public void deleteSweetness(Sweetness sweetness) throws RepositoryException {
        try {
            SweetnessValidator.isNull(sweetness);
            present.remove(findSweetness(sweetness));
        } catch (IncorrectValueException e) {
            logger.warn("Object to delete is null");
            throw new RepositoryException("Invalid object type");
        }
    }

    @Override
    public Sweetness getSweetness(Sweetness sweetness) throws RepositoryException {
        try {
            SweetnessValidator.isNull(sweetness);
            return findSweetness(sweetness);
        } catch (IncorrectValueException e) {
            logger.warn("Object to get is null");
            throw new RepositoryException("Invalid object");
        }
    }

    @Override
    public Set<Sweetness> getPresent() {
        return new HashSet(present);
    }

    @Override
    public Set<Sweetness> query(SweetnessSpecification specification) {
//        todo think how to fix this
        if (specification != null) {
            return specification.specify();
        }
        return null;
    }

    private Sweetness findSweetness(Sweetness findedSweetness) {
        for (Sweetness sweetness : present) {
            if (sweetness.equals(findedSweetness)) {
                return sweetness;
            }
        }
//        todo optional
        return null;
    }

}
