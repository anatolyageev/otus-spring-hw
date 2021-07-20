package ru.otus.ageev.hw03springboot.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.otus.ageev.hw03springboot.domain.Question;
import ru.otus.ageev.hw03springboot.utils.DataLoader;

import java.util.Collections;
import java.util.List;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private final DataLoader dataLoader;
    private List<Question> questionList;

    @Autowired
    public QuestionRepositoryImpl(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    @Override
    public List<Question> getAll() {
        questionList = dataLoader.getQuestionsFromCsv();
        return Collections.unmodifiableList(questionList);
    }
}
