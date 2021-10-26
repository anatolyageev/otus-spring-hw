package ru.otus.ageev.hw08springdatamongodb.service;

import ru.otus.ageev.hw08springdatamongodb.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll();

    Optional<Book> getById(String id);

    Book save(Book book);

    void update(Book book);

    void deleteById(String id);
}
