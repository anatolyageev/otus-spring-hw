package ru.otus.ageev.hw08springdatamongodb.service;

import ru.otus.ageev.hw08springdatamongodb.domain.Author;

import java.util.List;

public interface AuthorService {
    Author getById(String id);

    Author save(Author author);

    void saveAll(List<Author> authorList);
}
