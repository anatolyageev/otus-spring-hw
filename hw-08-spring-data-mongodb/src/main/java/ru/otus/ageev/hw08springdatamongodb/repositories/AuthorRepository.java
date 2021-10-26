package ru.otus.ageev.hw08springdatamongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.ageev.hw08springdatamongodb.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {

}
