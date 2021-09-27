package ru.otus.ageev.hw06jpa.service;

import ru.otus.ageev.hw06jpa.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll();

    Optional<Book> getById(long id);

    void save(Book book);

    void deleteById(long id);
}
