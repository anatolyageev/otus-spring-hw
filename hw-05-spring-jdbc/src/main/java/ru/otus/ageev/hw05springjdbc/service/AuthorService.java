package ru.otus.ageev.hw05springjdbc.service;

import ru.otus.ageev.hw05springjdbc.domain.Author;

import java.util.List;

public interface AuthorService {
    Author getById(long id);

    void save(Author author);

    void saveAll(List<Author> authorList);
}
