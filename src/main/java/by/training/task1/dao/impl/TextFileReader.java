package by.training.task1.dao.impl;

import by.training.task1.dao.DataReader;
import by.training.task1.entity.Sweetness;
import by.training.task1.exception.DAOException;
import by.training.task1.exception.IncorrectValueException;
import by.training.task1.factory.SweetnessFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader implements DataReader {

    SweetnessFactory sweetnessFactory = SweetnessFactory.INSTANCE;

    @Override
    public List<Sweetness> readAll(File file) throws DAOException{
        List<Sweetness> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    list.add(sweetnessFactory.getSweetnessFromString(line));
                } catch (IncorrectValueException e) {
                    throw new DAOException("Transmitted parameter is invalid", e);
                }
            }
        } catch (IOException e) {
            throw new DAOException("Data source problems", e);
        }
        return list;
    }
}
