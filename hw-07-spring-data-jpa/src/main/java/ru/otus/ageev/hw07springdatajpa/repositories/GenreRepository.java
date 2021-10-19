package ru.otus.ageev.hw07springdatajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.otus.ageev.hw07springdatajpa.domain.Genre;

import java.util.Optional;

public interface GenreRepository extends JpaRepository <Genre, Long> {

    Optional<Genre> getByGenreName(String genreName);
}
