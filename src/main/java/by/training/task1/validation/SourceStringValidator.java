package by.training.task1.validation;

import by.training.task1.entity.ChocolateType;
import by.training.task1.entity.FlavourType;
import by.training.task1.exception.IncorrectValueException;

public class SourceStringValidator {

    private static final int SWEETNESS_POLES_NUMBER = 3;
    private static final double MIN_WEIGHT = 0.001;
    private static final double MIN_SUGAR_CONTENT = 0;
    private static final double MAX_SUGAR_CONTENT = 10;

    public static void validateSweetness(String[] source) throws IncorrectValueException {
        isNull(source);
        validateLength(source);
        validateWeight(source[1]);
        validateSugarContent(source[2]);
    }

    public static void isNull(Object object) {
        if (object == null) {
            throw new IncorrectValueException("Value is null");
        }
    }

    public static void validateLength(String[] source) {
        if (source.length < SWEETNESS_POLES_NUMBER) {
            throw new IncorrectValueException("Incorrect parameters number");
        }
    }

    public static void validateWeight(String weight) {
        double value;
        try {
            value = Double.parseDouble(weight);
        } catch (NumberFormatException e) {
            throw new IncorrectValueException("Incorrect weight value");
        }

        if (value < MIN_WEIGHT) {
            throw new IncorrectValueException("Incorrect weight value");
        }
    }

    public static void validateSugarContent(String sugarContent) {
        double value;
        try {
            value = Double.parseDouble(sugarContent);
        } catch (NumberFormatException e) {
            throw new IncorrectValueException("Incorrect sugar content value");
        }

        if (value < MIN_SUGAR_CONTENT && value > MAX_SUGAR_CONTENT) {
            throw new IncorrectValueException("Incorrect sugar content value");
        }
    }

    public static void validateCaramelCandy(String[] source) {
        validateSweetness(source);

    }

    public static void validateFlavourType(String source) {
        try {
            FlavourType.valueOf(source);
        } catch (IllegalArgumentException e) {
            throw new IncorrectValueException("Invalid type value");
        }
    }

    public static void validateChocolateType(String source) {
        try {
            ChocolateType.valueOf(source);
        } catch (IllegalArgumentException e) {
            throw new IncorrectValueException("Invalid type value");
        }
    }


}