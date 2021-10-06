package ru.otus.ageev.hw07springdatajpa.service;

import ru.otus.ageev.hw07springdatajpa.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll();

    Optional<Book> getById(long id);

    void save(Book book);

    void update(Book book);

    void deleteById(long id);
}
