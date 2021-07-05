package ru.otus.ageev.hw03springboot.utils;

import java.util.List;

public interface StreamFromFile {
    List<String[]> readFileAsStream(int skipLine) throws Exception;
}
