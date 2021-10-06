package ru.otus.ageev.hw07springdatajpa.service;

import ru.otus.ageev.hw07springdatajpa.domain.Author;

public interface AuthorService {
    Author getById(long id);

    Author save(Author author);
}
