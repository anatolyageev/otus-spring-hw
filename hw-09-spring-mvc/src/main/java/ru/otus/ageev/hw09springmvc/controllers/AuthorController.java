package ru.otus.ageev.hw09springmvc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.ageev.hw09springmvc.domain.Author;
import ru.otus.ageev.hw09springmvc.service.AuthorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping(value = "/api/author")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAll(){
        return authorService.getAll();
    }
}
