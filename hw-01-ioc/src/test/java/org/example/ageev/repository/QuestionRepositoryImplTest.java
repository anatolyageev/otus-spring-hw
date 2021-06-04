package org.example.ageev.repository;

import org.example.ageev.domain.Question;
import org.example.ageev.utils.CsvDataLoader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class QuestionRepositoryImplTest {


    @Test
    public void getAllQuestionsTest() throws IOException {

        CsvDataLoader csvDataLoader = new CsvDataLoader("quiz.csv");
        QuestionRepository questionRepository = new QuestionRepositoryImpl(csvDataLoader);
        List<Question> questions = questionRepository.getAll();

        assertEquals(questions.size(), 3);
    }
}