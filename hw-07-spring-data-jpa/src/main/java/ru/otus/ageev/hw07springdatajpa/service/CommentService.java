package ru.otus.ageev.hw07springdatajpa.service;

import ru.otus.ageev.hw07springdatajpa.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllByBook(long bookId);
}
