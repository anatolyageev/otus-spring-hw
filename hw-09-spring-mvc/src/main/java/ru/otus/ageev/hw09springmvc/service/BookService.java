package ru.otus.ageev.hw09springmvc.service;

import ru.otus.ageev.hw09springmvc.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll();

    Optional<Book> getById(long id);

    Book save(Book book);

    void update(Book book);

    void deleteById(long id);
}
