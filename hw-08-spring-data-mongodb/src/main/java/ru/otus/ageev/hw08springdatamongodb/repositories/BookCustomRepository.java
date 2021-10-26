package ru.otus.ageev.hw08springdatamongodb.repositories;

import ru.otus.ageev.hw08springdatamongodb.domain.Author;

public interface BookCustomRepository {
    void setAuthorElementsById(Author source);

    void removeAuthorElementsById(String id);

    void removeCommentElementsById(String id);
}
