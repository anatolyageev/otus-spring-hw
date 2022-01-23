package ru.otus.ageev.hw08springdatamongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.ageev.hw08springdatamongodb.domain.Comment;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> getAllByBookId(String bookId);
}
