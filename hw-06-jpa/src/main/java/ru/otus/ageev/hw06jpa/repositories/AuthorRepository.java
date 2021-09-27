package ru.otus.ageev.hw06jpa.repositories;

import ru.otus.ageev.hw06jpa.domain.Author;

import java.util.List;

public interface AuthorRepository {
    List<Author> getAll();

    Author getById(long id);

    long insert(Author author);

    void update(Author author);
}
