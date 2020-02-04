package by.training.task1.util;

public class Parser {
    private static final String REGEX = "\\|";

    public String[] parseSourceToArray(String dataSourse) {
        return dataSourse.split(REGEX);
    }
}
