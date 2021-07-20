package ru.otus.ageev.hw03springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.ageev.hw03springboot.view.ViewQuiz;

import java.util.Scanner;

@Service
public class RequestUserCredentialsImpl implements RequestUserCredentials{
    private final ViewQuiz viewQuiz;

    @Autowired
    public RequestUserCredentialsImpl(ViewQuiz viewQuiz) {
        this.viewQuiz = viewQuiz;
    }

    @Override
    public void requestUserName() {
        viewQuiz.visualize("request.name");
    }

    @Override
    public String receiveUserName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
