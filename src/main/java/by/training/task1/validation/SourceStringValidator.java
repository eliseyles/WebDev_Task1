package by.training.task1.validation;

import by.training.task1.entity.ChocolateType;
import by.training.task1.entity.FlavourType;
import by.training.task1.exception.IncorrectValueException;
import org.apache.log4j.Logger;

public class SourceStringValidator {

    private static final int SWEETNESS_POLES_NUMBER = 3;
    private static final double MIN_WEIGHT = 0.001;
    private static final double MIN_SUGAR_CONTENT = 0;
    private static final double MAX_SUGAR_CONTENT = 10;

    static Logger logger = Logger.getLogger(SourceStringValidator.class);

    public static void validateSweetness(String[] source) throws IncorrectValueException {
        isNull(source);
        validateLength(source);
        validateWeight(source[1]);
        validateSugarContent(source[2]);
    }

    private static void isNull(Object object) throws IncorrectValueException{
        if (object == null) {
            logger.warn("Source string is null");
            throw new IncorrectValueException("Value is null");
        }
    }

    private static void validateLength(String[] source) throws IncorrectValueException{
        if (source.length < SWEETNESS_POLES_NUMBER) {
            logger.warn("Incorrect params number");
            throw new IncorrectValueException("Incorrect parameters number");
        }
    }

    private static void validateWeight(String weight) throws IncorrectValueException{
        double value;
        try {
            value = Double.parseDouble(weight);
        } catch (NumberFormatException e) {
            logger.warn("Cannot parse to double");
            throw new IncorrectValueException("Incorrect weight value");
        }

        if (value < MIN_WEIGHT) {
            logger.warn("Weight value less min value");
            throw new IncorrectValueException("Incorrect weight value");
        }
    }

    private static void validateSugarContent(String sugarContent) throws IncorrectValueException{
        double value;
        try {
            value = Double.parseDouble(sugarContent);
        } catch (NumberFormatException e) {
            logger.warn("Cannot parse to double");
            throw new IncorrectValueException("Incorrect sugar content value");
        }

        if (value < MIN_SUGAR_CONTENT && value > MAX_SUGAR_CONTENT) {
            logger.warn("Sugar content out of the bounds");
            throw new IncorrectValueException("Incorrect sugar content value");
        }
    }

    public static void validateFlavourType(String source) throws IncorrectValueException{
        try {
            FlavourType.valueOf(source);
        } catch (IllegalArgumentException e) {
            logger.warn("Source flavour type not correct");
            throw new IncorrectValueException("Invalid type value");
        }
    }

    public static void validateChocolateType(String source) throws IncorrectValueException{
        try {
            ChocolateType.valueOf(source);
        } catch (IllegalArgumentException e) {
            logger.warn("Source chocolate type not correct");
            throw new IncorrectValueException("Invalid type value");
        }
    }


}
