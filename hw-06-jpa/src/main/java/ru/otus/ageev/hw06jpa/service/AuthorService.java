package ru.otus.ageev.hw06jpa.service;

import ru.otus.ageev.hw06jpa.domain.Author;

public interface AuthorService {
    Author getById(long id);

    Author save(Author author);
}
