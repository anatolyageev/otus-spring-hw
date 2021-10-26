package ru.otus.ageev.hw08springdatamongodb.service;

import ru.otus.ageev.hw08springdatamongodb.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllByBook(String bookId);
}
