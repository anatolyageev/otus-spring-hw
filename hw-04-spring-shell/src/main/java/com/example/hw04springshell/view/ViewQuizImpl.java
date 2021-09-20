package com.example.hw04springshell.view;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ViewQuizImpl implements ViewQuiz {
    private final MessageSource messageSource;
    private final Locale locale;

    public ViewQuizImpl(MessageSource messageSource, Locale locale) {
        this.messageSource = messageSource;
        this.locale = locale;
    }

    public void visualize(String propertyName, Object... args){
        String result = messageSource.getMessage(propertyName, args, locale);
        System.out.println(result);
    }
}
