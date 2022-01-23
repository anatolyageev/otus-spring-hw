package ru.otus.ageev.hw09springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ageev.hw09springmvc.domain.Genre;

import java.util.Optional;

public interface GenreRepository extends JpaRepository <Genre, Long> {
    //Some changes
    Optional<Genre> getByGenreName(String genreName);
}
