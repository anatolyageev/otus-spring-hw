package ru.otus.ageev.hw06jpa.service;

import ru.otus.ageev.hw06jpa.domain.AuthorBookRelation;

import java.util.List;

public interface AuthorBookService {
    void save(AuthorBookRelation authorBook);
    void saveAll(List<AuthorBookRelation> authorBooks);
}
