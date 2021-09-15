package com.example.hw04springshell.domain;

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
