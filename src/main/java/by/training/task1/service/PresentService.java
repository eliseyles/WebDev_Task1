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
import org.apache.log4j.Logger;

import java.util.*;

public class PresentService {
    PresentRepository present = PresentRepositoryImpl.INSTANCE;

    Logger logger = Logger.getLogger(PresentRepository.class);

    public void addSweetness(Sweetness sweetness) throws ServiceException {
        try {
            SweetnessValidator.isNull(sweetness);
            present.addSweetness(sweetness);
        } catch (IncorrectValueException e) {
            logger.warn("Cannot add sweetness, was finded null");
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
            logger.warn("Cannot delete sweetness, was finded null");
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
            logger.warn("Cannot get sweetness, was finded null");
            throw new ServiceException("Invalid object type");
        } catch (RepositoryException e) {
            throw new ServiceException("Getting was interrupted");
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

    public Set<Sweetness> sortPresent(Comparator<Sweetness> comparator) {
        List<Sweetness> present = new ArrayList<>(this.present.getPresent());
        quickSort(present, comparator, 0, present.size());
        return new HashSet<>(present);
    }

    private void quickSort(List<Sweetness> array, Comparator<Sweetness> comparator, int low, int high) {
        if (array == null || array.size() == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        Sweetness pivot = array.get(middle);
        int i = low;
        int j = high;
        while (i <= j) {
            while (comparator.compare(array.get(i), pivot) < 0) {
                i++;
            }

            while (comparator.compare(array.get(j), pivot) > 0) {
                j--;
            }

            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, comparator, low, j);
        if (high > i)
            quickSort(array, comparator, i, high);
    }

    private void swap(List<Sweetness> employees, int firstElementIndex, int secondElementIndex) {
        Sweetness swap = employees.get(firstElementIndex);
        employees.set(firstElementIndex, employees.get(secondElementIndex));
        employees.set(secondElementIndex, swap);
    }

    public double getPresentWeight() {
        double totalWeight = 0;
        for (Sweetness sweetness : present.getPresent()) {
            totalWeight += sweetness.getWeight();
        }
        return totalWeight;
    }
}
