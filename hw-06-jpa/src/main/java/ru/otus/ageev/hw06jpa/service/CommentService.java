package ru.otus.ageev.hw06jpa.service;

import ru.otus.ageev.hw06jpa.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllByBook(long bookId);
}
