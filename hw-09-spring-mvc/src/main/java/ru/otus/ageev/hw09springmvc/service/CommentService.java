package ru.otus.ageev.hw09springmvc.service;

import ru.otus.ageev.hw09springmvc.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllByBook(long bookId);
}
