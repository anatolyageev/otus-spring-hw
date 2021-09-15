package com.example.hw04springshell.repository;

import com.example.hw04springshell.domain.Question;
import com.example.hw04springshell.utils.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
