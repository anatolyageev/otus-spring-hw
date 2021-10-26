package ru.otus.ageev.hw08springdatamongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.ageev.hw08springdatamongodb.domain.Genre;

import java.util.Optional;

public interface GenreRepository extends MongoRepository<Genre, String> {

    Optional<Genre> getByGenreName(String genreName);
}
