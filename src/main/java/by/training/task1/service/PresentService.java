package by.training.task1.service;

import by.training.task1.entity.Sweetness;
import by.training.task1.exception.IncorrectValueException;
import by.training.task1.exception.RepositoryException;
import by.training.task1.exception.ServiceException;
import by.training.task1.repository.PresentRepository;
import by.training.task1.repository.impl.PresentRepositoryImpl;
import by.training.task1.specification.impl.GetAllCaramelCandySpecification;
import by.training.task1.specification.impl.GetAllChocolateCandySpecification;
import by.training.task1.specification.impl.GetSweetnessSugarBetweenValueSpecification;
import by.training.task1.validation.SweetnessValidator;

import java.util.Set;

public class PresentService {
    PresentRepository present = PresentRepositoryImpl.INSTANCE;

    public void addSweetness(Sweetness sweetness) throws ServiceException {
        try {
            SweetnessValidator.isNull(sweetness);
            present.addSweetness(sweetness);
        } catch (IncorrectValueException e) {
            throw new ServiceException("Invalid object type");
        } catch (RepositoryException e) {
            throw new ServiceException("Adding was interrupted");
        }
    }

    public void deleteSweetness(Sweetness sweetness) throws ServiceException {
        try {
            SweetnessValidator.isNull(sweetness);
            present.deleteSweetness(sweetness);
        } catch (IncorrectValueException e) {
            throw new ServiceException("Invalid object type");
        } catch (RepositoryException e) {
            throw new ServiceException("Deleting was interrupted");
        }
    }

    public Sweetness getSweetness(Sweetness sweetness) throws ServiceException {
        try {
            SweetnessValidator.isNull(sweetness);
            return present.getSweetness(sweetness);
        } catch (IncorrectValueException e) {
            throw new ServiceException("Invalid object type");
        } catch (RepositoryException e) {
            throw new ServiceException("Deleting was interrupted");
        }
    }

    public Set<Sweetness> getAllPresent() {
        return present.getPresent();
    }

    public Set<Sweetness> getCaramelCandysFromPresent() {
        return present.query(new GetAllCaramelCandySpecification());
    }

    public Set<Sweetness> getChocolateCandysFromPresent() {
        return present.query(new GetAllChocolateCandySpecification());
    }

    public Set<Sweetness> getSweetnessWithSugarContentBetweenValues(double minValue, double maxValue) {
        return present.query(new GetSweetnessSugarBetweenValueSpecification(minValue, maxValue));
    }
}
