package ru.otus.ageev.hw06jpa.repositories;

import ru.otus.ageev.hw06jpa.domain.Comment;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment>{
   List<Comment> getAllByBook(long bookId);
}
