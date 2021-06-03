package org.example.ageev.service;

import org.example.ageev.domain.Question;
import org.example.ageev.repository.QuestionRepository;

import java.util.List;

public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.getAll();
    }
}
