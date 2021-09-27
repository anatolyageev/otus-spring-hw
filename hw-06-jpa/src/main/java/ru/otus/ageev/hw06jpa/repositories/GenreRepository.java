package ru.otus.ageev.hw06jpa.repositories;

import ru.otus.ageev.hw06jpa.domain.Genre;

import java.util.List;

public interface GenreRepository {
    Genre getById(long id);
    Genre getByName(String genreName);
    List<Genre> getAll();
}
