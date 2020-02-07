package by.training.task1.dao;

import by.training.task1.entity.Sweetness;
import by.training.task1.exception.DAOException;

import java.io.File;
import java.util.List;

public interface DataReader {
    List<Sweetness> readAll(File file) throws DAOException;
}
