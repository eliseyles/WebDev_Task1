package by.training.task1.validation;

import by.training.task1.entity.Sweetness;
import by.training.task1.exception.IncorrectValueException;
import by.training.task1.exception.RepositoryException;
import org.apache.log4j.Logger;

public class SweetnessValidator {

    static Logger logger = Logger.getLogger(Sweetness.class);

    public static void isNull(Sweetness sweetness) throws IncorrectValueException {
        if (sweetness == null) {
            logger.warn("Object is null");
            throw new IncorrectValueException("Invalid object null");
        }
    }
}
