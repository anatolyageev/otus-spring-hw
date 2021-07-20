package ru.otus.ageev.hw03springboot.repository;


import ru.otus.ageev.hw03springboot.domain.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> getAll();
}
