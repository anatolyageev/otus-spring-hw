package ru.otus.ageev.hw03springboot.utils;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.otus.ageev.hw03springboot.domain.Answer;
import ru.otus.ageev.hw03springboot.domain.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CsvDataLoader implements DataLoader {
    private final StreamFromFile streamFromFile;

    public CsvDataLoader(StreamFromFile streamFromFile) {
        this.streamFromFile = streamFromFile;
    }

    @SneakyThrows
    public List<Question> getQuestionsFromCsv() {
        List<String[]> result = streamFromFile.readFileAsStream(1);
        return getQuestionList(result);
    }

    private List<Question> getQuestionList(List<String[]> result) {
        List<Question> questions = new ArrayList<>();
        for (String[] arrays : result) {
            Question question = new Question(Long.parseLong(arrays[0]),
                    arrays[1],
                    Arrays.asList(
                            new Answer(arrays[2], Long.parseLong(arrays[0])),
                            new Answer(arrays[3], Long.parseLong(arrays[0])),
                            new Answer(arrays[4], Long.parseLong(arrays[0])),
                            new Answer(arrays[5], Long.parseLong(arrays[0]))),
                    arrays[6]);
            questions.add(question);
        }
        return questions;
    }
}
