package ru.otus.ageev.hw06jpa.service;

import ru.otus.ageev.hw06jpa.domain.Author;

import java.util.List;

public interface AuthorService {
    Author getById(long id);

    Author save(Author author);

    List<Author>  saveAll(List<Author> authorList);
}
