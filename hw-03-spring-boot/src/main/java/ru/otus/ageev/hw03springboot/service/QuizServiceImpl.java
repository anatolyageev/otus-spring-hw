package ru.otus.ageev.hw03springboot.service;

import org.springframework.stereotype.Service;
import ru.otus.ageev.hw03springboot.domain.Answer;
import ru.otus.ageev.hw03springboot.domain.Question;
import ru.otus.ageev.hw03springboot.view.ViewQuiz;

import java.util.List;
import java.util.Scanner;

@Service
public class QuizServiceImpl implements QuizService {
    private final QuestionService questionService;
    private final ViewQuiz viewQuiz;
    private int numberCorrectAnswers;
    private int totalNumberQuestions;
    private String studentName;

    public QuizServiceImpl(QuestionService questionService, ViewQuiz viewQuiz) {
        this.questionService = questionService;
        this.viewQuiz = viewQuiz;
    }


    @Override
    public void runQuiz() {
        initQuiz();
        mainPart();
        resultAndParting();
    }

    private void initQuiz() {
        viewQuiz.visualize("greeting");
        viewQuiz.visualize("request.name");
        Scanner scanner = new Scanner(System.in);
        studentName = scanner.nextLine();

    }

    private void mainPart() {
        List<Question> questions = questionService.getAll();
        totalNumberQuestions = questions.size();
        for (Question question : questions) {
            System.out.println("Question: " + question.getQuestion());
            int index = 1;
            for (Answer answer : question.getAnswerList()) {
                System.out.println("\t" + index++ + " " + answer.getAnswer());
            }
            userAnswerHandler(question);
        }
    }

    private void resultAndParting() {
        viewQuiz.visualize("result", studentName, numberCorrectAnswers * 100 / totalNumberQuestions);
        viewQuiz.visualize("parting");
    }

    private void userAnswerHandler(Question question) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int userAnswer = scanner.nextInt();
            if ((userAnswer >= 1) && (userAnswer <= 4)) {
                if (question.getAnswerList().get(userAnswer - 1).getAnswer().equals(question.getCorrectAnswer())) {
                    numberCorrectAnswers++;
                    break;
                } else {
                    break;
                }
            } else {
                viewQuiz.visualize("massage.wrong_enter");
            }
        }
    }

}
