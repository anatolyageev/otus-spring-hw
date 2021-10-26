package ru.otus.ageev.hw08springdatamongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.ageev.hw08springdatamongodb.domain.Book;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String>, BookCustomRepository {
    @Override
    List<Book> findAll();
}
