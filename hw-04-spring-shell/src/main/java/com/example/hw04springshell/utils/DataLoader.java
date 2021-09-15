package com.example.hw04springshell.utils;

import com.example.hw04springshell.domain.Question;

import java.util.List;

public interface DataLoader {
    List<Question> getQuestionsFromCsv();
}
