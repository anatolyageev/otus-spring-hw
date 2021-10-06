package ru.otus.ageev.hw07springdatajpa.service;

import ru.otus.ageev.hw07springdatajpa.domain.Genre;

import java.util.List;

public interface GenreService {
    Genre getById(long id);
    Genre getByName(String genreName);
    List<Genre> getAll();
}
