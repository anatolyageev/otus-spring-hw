package ru.otus.ageev.hw05springjdbc.service;

import ru.otus.ageev.hw05springjdbc.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    Book getById(long id);

    void save(Book book);

    void deleteById(long id);
}
