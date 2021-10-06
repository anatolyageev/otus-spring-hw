package ru.otus.ageev.hw07springdatajpa.repositories;

import ru.otus.ageev.hw07springdatajpa.domain.Genre;

import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre> {

    Optional<Genre> getByName(String genreName);
}
