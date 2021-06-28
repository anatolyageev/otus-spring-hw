package ru.otus.ageev.hw03springboot.service;

import ru.otus.ageev.hw03springboot.domain.Question;

import java.util.List;

public interface QuestionService {
   List<Question> getAll();
}
