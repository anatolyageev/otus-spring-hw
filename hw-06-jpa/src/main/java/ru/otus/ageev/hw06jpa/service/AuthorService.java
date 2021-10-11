package ru.otus.ageev.hw06jpa.service;

import ru.otus.ageev.hw06jpa.domain.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();

    Author getById(long id);

    Author save(Author author);

    void saveAll(List<Author> authorList);
}
