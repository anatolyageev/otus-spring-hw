package ru.otus.ageev.hw05springjdbc.dao;

import ru.otus.ageev.hw05springjdbc.domain.Book;

import java.util.List;

public interface BookDao {

    List<Book> getAll();

    Book getById(long id);

    long insert(Book book);

    void update(Book book);

    void deleteById(long id);
}
