package org.example.ageev.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(exclude = "questionId")
public class Answer {
    private final String answer;
    private final long questionId;

    public Answer(String answer, long questionId) {
        this.answer = answer;
        this.questionId = questionId;
    }
}
