package com.example.hw04springshell.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString(exclude = "correctAnswer")
public class Question {
    private final long id;
    private final String question;
    private final List<Answer> answerList;
    private final String correctAnswer;


    public Question(long id, String question, List<Answer> answerList, String correctAnswer) {
        this.id = id;
        this.question = question;
        this.answerList = answerList;
        this.correctAnswer = correctAnswer;
    }
}
