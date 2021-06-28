package ru.otus.ageev.hw03springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.otus.ageev.hw03springboot.service.QuizService;

@SpringBootApplication
public class Hw03SpringBootApplication {

    public static void main(String[] args) {
      ConfigurableApplicationContext context = SpringApplication.run(Hw03SpringBootApplication.class, args);
        context.getBean(QuizService.class).runQuiz();
    }

}
