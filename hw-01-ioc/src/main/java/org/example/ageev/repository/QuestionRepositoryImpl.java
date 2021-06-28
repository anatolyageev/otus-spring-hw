package org.example.ageev.repository;

import org.example.ageev.domain.Question;
import org.example.ageev.utils.CsvDataLoader;

import java.util.Collections;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {

    private final CsvDataLoader csvDataLoader;
    private final List<Question> questionList;

    public QuestionRepositoryImpl(CsvDataLoader csvDataLoader) {
        this.csvDataLoader = csvDataLoader;
        questionList = csvDataLoader.getQuestionsFromCsv();
    }

    @Override
    public List<Question> getAll() {
        return Collections.unmodifiableList(questionList);
    }
}
