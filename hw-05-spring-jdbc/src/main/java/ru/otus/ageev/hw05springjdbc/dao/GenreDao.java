package ru.otus.ageev.hw05springjdbc.dao;

import ru.otus.ageev.hw05springjdbc.domain.Author;
import ru.otus.ageev.hw05springjdbc.domain.Genre;

public interface GenreDao {
    Genre getById(long id);
}
