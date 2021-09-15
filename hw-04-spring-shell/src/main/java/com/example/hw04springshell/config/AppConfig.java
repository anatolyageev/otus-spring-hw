package com.example.hw04springshell.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class AppConfig {
    @Bean
    public Locale locale(@Value("${quiz.locale}") Locale locale){
        return locale;
    }
}
