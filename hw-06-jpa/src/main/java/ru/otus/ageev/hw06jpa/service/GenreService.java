package ru.otus.ageev.hw06jpa.service;

import ru.otus.ageev.hw06jpa.domain.Genre;

import java.util.List;

public interface GenreService {
    Genre getById(long id);
    Genre getByName(String genreName);
    List<Genre> getAll();
}
