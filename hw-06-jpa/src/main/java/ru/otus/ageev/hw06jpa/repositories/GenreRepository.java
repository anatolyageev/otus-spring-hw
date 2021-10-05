package ru.otus.ageev.hw06jpa.repositories;

import ru.otus.ageev.hw06jpa.domain.Genre;

import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre> {

    Optional<Genre> getByName(String genreName);
}
