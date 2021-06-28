package ru.otus.ageev.hw03springboot.utils;

import ru.otus.ageev.hw03springboot.domain.Question;

import java.util.List;

public interface DataLoader {
    List<Question> getQuestionsFromCsv();
}
