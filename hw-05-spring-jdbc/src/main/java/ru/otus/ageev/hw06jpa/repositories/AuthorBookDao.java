package ru.otus.ageev.hw06jpa.repositories;

import ru.otus.ageev.hw06jpa.domain.AuthorBookRelation;

import java.util.List;

public interface AuthorBookDao {

    List<AuthorBookRelation> getByBookId(long id);

    List<AuthorBookRelation> getByAuthorId(long id);

    boolean isExist(AuthorBookRelation authorBook);

    void insert(AuthorBookRelation authorBook);

    void deleteById(AuthorBookRelation authorBook);
}
