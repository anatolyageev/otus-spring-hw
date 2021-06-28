package ru.otus.ageev.hw03springboot.service;

import org.springframework.stereotype.Service;
import ru.otus.ageev.hw03springboot.domain.Question;
import ru.otus.ageev.hw03springboot.repository.QuestionRepository;

import java.util.List;

@Service
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
