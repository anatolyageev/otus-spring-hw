package com.example.hw04springshell.utils;

import com.example.hw04springshell.domain.Question;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DisplayName("In CsvDataLoaderTest ")
class CsvDataLoaderTest {

    @TestConfiguration
    static class TestConfig {
        @Bean
        @Primary
        public StreamFromFile streamFromFile() {
            return new StreamFromFileImpl("quiz/quiz", Locale.forLanguageTag("en"));
        }
    }

    @Autowired
    CsvDataLoader csvDataLoader;

    @DisplayName("Load rows more then 0")
    @Test
    void getQuestionsFromCsv() {
        List<Question> questionsFromCsv = csvDataLoader.getQuestionsFromCsv();
        assertTrue(questionsFromCsv.size() > 0);
    }
}