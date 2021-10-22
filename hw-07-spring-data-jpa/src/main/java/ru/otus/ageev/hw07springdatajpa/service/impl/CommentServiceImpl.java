package ru.otus.ageev.hw07springdatajpa.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ageev.hw07springdatajpa.domain.Comment;
import ru.otus.ageev.hw07springdatajpa.repositories.CommentRepository;
import ru.otus.ageev.hw07springdatajpa.service.CommentService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<Comment> getAllByBook(long bookId) {
        return commentRepository.getAllByBookId(bookId);
    }
}
