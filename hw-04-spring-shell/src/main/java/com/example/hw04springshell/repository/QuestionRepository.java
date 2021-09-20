package com.example.hw04springshell.repository;

import com.example.hw04springshell.domain.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> getAll();
}
