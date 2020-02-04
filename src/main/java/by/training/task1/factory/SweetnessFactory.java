package by.training.task1.factory;

import by.training.task1.entity.*;
import by.training.task1.exception.IncorrectValueException;
import by.training.task1.util.Parser;

public class SweetnessFactory {

    public SweetnessFactory() {
    }

    public static Sweetness getSweetnessFromString(String dataSource) {
        Sweetness sweetness;
        String[] data = new Parser().parseSourceToArray(dataSource);

        if (data.length == 4 || data.length == 5) {
            switch (data[0]) {
                case "Sweetness":
                    sweetness = new Sweetness(Double.parseDouble(data[1]), Double.parseDouble(data[2]),
                            Double.parseDouble(data[3]));
                    break;
                case "CaramelCandy":
                    sweetness = new CaramelCandy(Double.parseDouble(data[1]),
                            Double.parseDouble(data[2]), Double.parseDouble(data[3]), FlavourType.valueOf(data[4]));
                    break;
                case "ChocolateCandy":
                    sweetness = new ChocolateCandy(Double.parseDouble(data[1]),
                            Double.parseDouble(data[2]), Double.parseDouble(data[3]), ChocolateType.valueOf(data[4]));
                    break;
                default:
                    throw new IncorrectValueException("Incorrect sweetness type");
            }
        } else {
            throw new IncorrectValueException("Incorrect parametrs number");
        }
        return sweetness;
    }


}
