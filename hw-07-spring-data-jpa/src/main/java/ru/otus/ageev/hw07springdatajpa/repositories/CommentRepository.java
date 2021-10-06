package ru.otus.ageev.hw07springdatajpa.repositories;

import ru.otus.ageev.hw07springdatajpa.domain.Comment;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment>{
   List<Comment> getAllByBook(long bookId);
}
