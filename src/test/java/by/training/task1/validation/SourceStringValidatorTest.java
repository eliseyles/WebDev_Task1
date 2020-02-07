package by.training.task1.validation;

import by.training.task1.exception.IncorrectValueException;
import org.junit.Test;

import static org.junit.Assert.*;

public class SourceStringValidatorTest {

    @Test(expected = IncorrectValueException.class)
    public void validateSweetnessTestNullSource() throws IncorrectValueException {
        SourceStringValidator.validateSweetness(null);
    }

    @Test(expected = IncorrectValueException.class)
    public void validateSweetnessTestWrongLength() throws IncorrectValueException {
        SourceStringValidator.validateSweetness(new String[]{});
    }

    @Test(expected = IncorrectValueException.class)
    public void validateSweetnessTestIncorrectDouble() throws IncorrectValueException {
        SourceStringValidator.validateSweetness(new String[]{null, "every", null});
    }

    @Test
    public void validateSweetnessTestCorrectWeight() throws IncorrectValueException {
        SourceStringValidator.validateSweetness(new String[]{null, "10.6", "5"});
    }

    @Test(expected = IncorrectValueException.class)
    public void validateSweetnessTestIncorrectWeight() throws IncorrectValueException {
        SourceStringValidator.validateSweetness(new String[]{null, "-1", "5"});
    }

    @Test(expected = IncorrectValueException.class)
    public void validateSweetnessTestIncorrectSugarContentDouble() throws IncorrectValueException {
        SourceStringValidator.validateSweetness(new String[]{null, "0.1", "smth"});
    }

    @Test
    public void validateSweetnessTestCorrectSweetness() throws IncorrectValueException {
        SourceStringValidator.validateSweetness(new String[]{null, "0.15", "6"});
    }

    @Test(expected = IncorrectValueException.class)
    public void validateFlavourTypeTestNotParsed() throws IncorrectValueException{
        SourceStringValidator.validateFlavourType("smth");
    }

    @Test
    public void validateFlavourTypeTestParsed() throws IncorrectValueException{
        SourceStringValidator.validateFlavourType("ORANGE");
    }

    @Test(expected = IncorrectValueException.class)
    public void validateChocolateTypeNotParsed() throws IncorrectValueException{
        SourceStringValidator.validateChocolateType("smth");
    }

    @Test
    public void validateChocolateTypeParsed() throws IncorrectValueException{
        SourceStringValidator.validateChocolateType("MILK");
    }
}