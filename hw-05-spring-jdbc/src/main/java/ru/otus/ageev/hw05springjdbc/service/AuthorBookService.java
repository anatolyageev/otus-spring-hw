package ru.otus.ageev.hw05springjdbc.service;

import ru.otus.ageev.hw05springjdbc.domain.AuthorBookRelation;

import java.util.List;

public interface AuthorBookService {
    void save(AuthorBookRelation authorBook);
    void saveAll(List<AuthorBookRelation> authorBooks);
}
