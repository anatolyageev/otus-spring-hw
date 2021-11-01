package ru.otus.ageev.hw09springmvc.service;

import ru.otus.ageev.hw09springmvc.domain.Genre;

import java.util.List;

public interface GenreService {
    Genre getById(long id);
    Genre getByName(String genreName);
    List<Genre> getAll();
}
