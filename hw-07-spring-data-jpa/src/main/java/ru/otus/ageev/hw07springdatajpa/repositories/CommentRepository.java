package ru.otus.ageev.hw07springdatajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ageev.hw07springdatajpa.domain.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> getAllByBookId(long bookId);
}
