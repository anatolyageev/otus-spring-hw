package ru.otus.ageev.hw09springmvc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ageev.hw09springmvc.domain.Comment;
import ru.otus.ageev.hw09springmvc.repositories.CommentRepository;
import ru.otus.ageev.hw09springmvc.service.CommentService;

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
