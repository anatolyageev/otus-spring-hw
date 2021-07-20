package ru.otus.ageev.hw05springjdbc.dao;

import ru.otus.ageev.hw05springjdbc.domain.Author;
import ru.otus.ageev.hw05springjdbc.domain.Book;

import java.util.List;

public interface AuthorDao {
    List<Author> getAll();

    Author getById(long id);

    long insert(Author author);

    void update(Author author);

    void deleteById(long id);
}
