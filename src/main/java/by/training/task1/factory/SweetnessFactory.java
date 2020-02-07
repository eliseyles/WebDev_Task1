package by.training.task1.factory;

import by.training.task1.entity.*;
import by.training.task1.exception.IncorrectValueException;
import by.training.task1.util.Parser;
import by.training.task1.validation.SourceStringValidator;

public enum SweetnessFactory {

    INSTANCE;

    public Sweetness getSweetnessFromString(String dataSource) throws IncorrectValueException{
        Sweetness sweetness;
        String[] data = new Parser().parseSourceToArray(dataSource);

        SourceStringValidator.validateSweetness(data);
        switch (data[0]) {
            case "CaramelCandy":
                SourceStringValidator.validateFlavourType(data[3]);
                sweetness = new CaramelCandy(Double.parseDouble(data[1]),
                        Double.parseDouble(data[2]), FlavourType.valueOf(data[3]));
                break;
            case "ChocolateCandy":
                SourceStringValidator.validateChocolateType(data[3]);
                sweetness = new ChocolateCandy(Double.parseDouble(data[1]),
                        Double.parseDouble(data[2]), ChocolateType.valueOf(data[3]));
                break;
            default:
                throw new IncorrectValueException("Incorrect sweetness type");
        }

        return sweetness;
    }


}
