package com.example.hw04springshell.view.shell;


import com.example.hw04springshell.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventsCommands {
    private final QuizService questionService;
    private String userName;

    @ShellMethod(value = "Login command", key = {"l", "login"})
    public String login(String userName) {
        this.userName = userName;
        return String.format("Welcome: %s", userName);
    }

    @ShellMethod(value = "Start Quiz", key = {"s", "start"})
    @ShellMethodAvailability(value = "isStartCommandAvailable")
    public void startQuiz() {
        questionService.runQuiz(userName);
    }

    private Availability isStartCommandAvailable() {
        return userName == null ? Availability.unavailable("Please enter your name") : Availability.available();
    }
}
