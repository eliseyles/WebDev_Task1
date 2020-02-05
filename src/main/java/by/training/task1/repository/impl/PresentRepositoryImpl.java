package by.training.task1.repository.impl;

import by.training.task1.entity.CaramelCandy;
import by.training.task1.entity.Sweetness;

import java.util.HashSet;

public class PresentRepositoryImpl {
    HashSet<Sweetness> hashSet = new HashSet<>();

    public void add(CaramelCandy caramelCandy) {
        hashSet.add(caramelCandy);
    }
}
