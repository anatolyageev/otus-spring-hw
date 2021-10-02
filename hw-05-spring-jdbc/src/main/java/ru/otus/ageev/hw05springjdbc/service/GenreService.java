package ru.otus.ageev.hw05springjdbc.service;

import ru.otus.ageev.hw05springjdbc.domain.Genre;

import java.util.List;

public interface GenreService {
    Genre getById(long id);
    Genre getByName(String genreName);
    List<Genre> getAll();
}
