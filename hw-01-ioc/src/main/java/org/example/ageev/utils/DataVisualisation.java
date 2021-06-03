package org.example.ageev.utils;

import lombok.extern.slf4j.Slf4j;
import org.example.ageev.domain.Answer;
import org.example.ageev.domain.Question;
import org.example.ageev.service.QuestionService;

import java.util.List;

@Slf4j
public class DataVisualisation {
    private final QuestionService questionService;

    public DataVisualisation(QuestionService questionService) {
        this.questionService = questionService;
    }

    public void showAllQuestions(){
      List<Question> questions = questionService.getAll();
      for (Question question : questions) {
          System.out.println("Question: " + question.getQuestion());
          for(Answer answer: question.getAnswerList()){
              System.out.println("\t*"+answer.getAnswer());
          }
      }
    }
}
