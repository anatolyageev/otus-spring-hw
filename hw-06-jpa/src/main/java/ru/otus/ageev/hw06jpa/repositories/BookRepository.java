package ru.otus.ageev.hw06jpa.repositories;

import ru.otus.ageev.hw06jpa.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<Book> getAll();

    Optional<Book> getById(long id);

    long insert(Book book);

    void update(Book book);

    void deleteById(long id);
}
