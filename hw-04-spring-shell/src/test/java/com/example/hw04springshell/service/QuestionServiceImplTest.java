package com.example.hw04springshell.service;

import com.example.hw04springshell.domain.Answer;
import com.example.hw04springshell.domain.Question;
import com.example.hw04springshell.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class QuestionServiceImplTest {

    @MockBean
    QuestionRepository questionRepository;

    @Autowired
    QuestionServiceImpl questionService;

    List<Question> questionList = new ArrayList<>(Arrays.asList(
            new Question(1, "One", new ArrayList<Answer>(Arrays.asList(new Answer("1", 1), new Answer("2", 1))), "1"),
            new Question(2, "Two", new ArrayList<Answer>(Arrays.asList(new Answer("1", 2), new Answer("2", 2))), "1")));

    @Test
    void getAll() {
        when(questionRepository.getAll()).thenReturn(questionList);
        List<Question> questionList = questionService.getAll();
        System.out.println(questionList);
        assertTrue(questionList.size() == 2);
    }
}