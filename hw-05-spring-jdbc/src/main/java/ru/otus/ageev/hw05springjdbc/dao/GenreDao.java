package ru.otus.ageev.hw05springjdbc.dao;

import ru.otus.ageev.hw05springjdbc.domain.Author;
import ru.otus.ageev.hw05springjdbc.domain.Genre;

import java.util.List;

public interface GenreDao {
    Genre getById(long id);
    Genre getByName(String genreName);
    List<Genre> getAll();
}
