package ru.otus.ageev.hw05springjdbc.dao;

import ru.otus.ageev.hw05springjdbc.domain.AuthorBook;
import ru.otus.ageev.hw05springjdbc.domain.Book;

import java.util.List;

public interface AuthorBookDao {

    List<AuthorBook> getByBookId(long id);

    List<AuthorBook> getByAuthorId(long id);

    boolean isExist(AuthorBook authorBook);

    void insert(AuthorBook authorBook);

    void deleteById(AuthorBook authorBook);
}
