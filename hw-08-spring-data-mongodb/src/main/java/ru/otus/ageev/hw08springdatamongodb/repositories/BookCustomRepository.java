package ru.otus.ageev.hw08springdatamongodb.repositories;

import ru.otus.ageev.hw08springdatamongodb.domain.Author;
import ru.otus.ageev.hw08springdatamongodb.domain.Genre;

public interface BookCustomRepository {
    void setAuthorElementsById(Author source);

    void removeAuthorElementsById(String id);

    void removeCommentElementsById(String id);

    void setGenreElementsById(Genre genre);
}
