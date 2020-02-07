package by.training.task1.factory;

import by.training.task1.entity.*;
import by.training.task1.exception.IncorrectValueException;
import by.training.task1.repository.impl.PresentRepositoryImpl;
import by.training.task1.util.Parser;
import by.training.task1.validation.SourceStringValidator;
import org.apache.log4j.Logger;

public enum SweetnessFactory {

    INSTANCE;

    Logger logger = Logger.getLogger(SweetnessFactory.class);

    public Sweetness getSweetnessFromString(String dataSource) throws IncorrectValueException {
        Sweetness sweetness = null;
        String[] data = new Parser().parseSourceToArray(dataSource);

        SourceStringValidator.validateSweetness(data);

        if (data.length > 3) {
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
                    logger.warn("Not find such sweetness");
                    throw new IncorrectValueException("Incorrect sweetness type");
            }
        } else {
            logger.warn("Invalid source params number");
            throw new IncorrectValueException("Invalid source length");
        }


        return sweetness;
    }


}
