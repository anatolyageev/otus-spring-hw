package ru.otus.ageev.hw08springdatamongodb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ageev.hw08springdatamongodb.domain.Comment;
import ru.otus.ageev.hw08springdatamongodb.repositories.CommentRepository;
import ru.otus.ageev.hw08springdatamongodb.service.CommentService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<Comment> getAllByBook(String bookId) {
        return commentRepository.getAllByBookId(bookId);
    }
}
