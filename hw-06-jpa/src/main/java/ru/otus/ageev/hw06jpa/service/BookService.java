package ru.otus.ageev.hw06jpa.service;

import ru.otus.ageev.hw06jpa.domain.Book;
import ru.otus.ageev.hw06jpa.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll();

    Optional<Book> getById(long id);

    void save(Book book);

    void update(Book book);

    void deleteById(long id);

    List<Comment> getCommentsByBookId(Long bookId);
}
