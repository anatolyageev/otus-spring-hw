package ru.otus.ageev.hw08springdatamongodb.service;

import ru.otus.ageev.hw08springdatamongodb.domain.Genre;

import java.util.List;

public interface GenreService {
    Genre getById(String id);
    Genre getByName(String genreName);
    List<Genre> getAll();
}
