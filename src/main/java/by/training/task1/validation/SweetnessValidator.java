package by.training.task1.validation;

import by.training.task1.entity.Sweetness;
import by.training.task1.exception.IncorrectValueException;
import by.training.task1.exception.RepositoryException;

public class SweetnessValidator {

    public static void isNull(Sweetness sweetness) throws IncorrectValueException {
        if (sweetness == null) {
            throw new IncorrectValueException("Invalid object null");
        }
    }
}
