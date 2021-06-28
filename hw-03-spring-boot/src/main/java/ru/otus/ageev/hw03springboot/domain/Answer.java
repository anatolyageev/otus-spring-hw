package ru.otus.ageev.hw03springboot.domain;

import lombok.Getter;

@Getter
public class Answer {
    private final String answer;
    private final long questionId;

    public Answer(String answer, long questionId) {
        this.answer = answer;
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return  answer ;
    }
}
