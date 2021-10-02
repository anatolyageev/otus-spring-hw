package ru.otus.ageev.hw05springjdbc.service;

import ru.otus.ageev.hw05springjdbc.domain.Author;

import java.util.List;

public interface AuthorService {
    Author getById(long id);

    Author save(Author author);

    List<Author>  saveAll(List<Author> authorList);
}
