package ru.otus.ageev.hw03springboot.view;

import org.springframework.context.MessageSource;

public interface ViewQuiz {
    void visualize(String propertyName, Object... args);
}
