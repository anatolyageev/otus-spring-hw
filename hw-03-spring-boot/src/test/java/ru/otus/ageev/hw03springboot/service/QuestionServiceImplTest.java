package ru.otus.ageev.hw03springboot.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.ageev.hw03springboot.domain.Answer;
import ru.otus.ageev.hw03springboot.domain.Question;
import ru.otus.ageev.hw03springboot.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class QuestionServiceImplTest {
    @Mock
    QuestionRepository questionRepository;

    @InjectMocks
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