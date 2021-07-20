package ru.otus.ageev.hw05springjdbc.service;

import ru.otus.ageev.hw05springjdbc.domain.AuthorBook;

import java.util.List;

public interface AuthorBookService {
    void save(AuthorBook authorBook);
    void saveAll(List<AuthorBook> authorBooks);
}
