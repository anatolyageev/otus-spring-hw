package ru.otus.ageev.hw07springdatajpa.service;

import ru.otus.ageev.hw07springdatajpa.domain.Author;

import java.util.List;

public interface AuthorService {
    Author getById(long id);

    Author save(Author author);

    void saveAll(List<Author> authorList);
}
