package org.example.ageev.repository;

import org.example.ageev.domain.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> getAll();
}
