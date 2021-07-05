package ru.otus.ageev.hw03springboot.utils;

import org.junit.jupiter.api.Test;
import ru.otus.ageev.hw03springboot.domain.Question;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CsvDataLoaderTest {
    StreamFromFileImpl streamFromFile = new StreamFromFileImpl("quiz/quiz", Locale.forLanguageTag("ru"));

    @Test
    void getQuestionsFromCsv() {
        CsvDataLoader csvDataLoader = new CsvDataLoader(streamFromFile);

        List<Question> questionsFromCsv = csvDataLoader.getQuestionsFromCsv();
        assertTrue(questionsFromCsv.size()>0);
    }
}