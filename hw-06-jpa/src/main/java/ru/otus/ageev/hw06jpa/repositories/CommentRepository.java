package ru.otus.ageev.hw06jpa.repositories;

import ru.otus.ageev.hw06jpa.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository{

    List<Comment> getAll();

    Optional<Comment> getComment(Long id);

    List<Comment> getBookComments(Long bookId);

    void delete(Long id);

    Comment save(Comment comment);
}
