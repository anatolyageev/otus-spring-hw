package ru.otus.ageev.hw06jpa.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ageev.hw06jpa.domain.Comment;
import ru.otus.ageev.hw06jpa.repositories.CommentRepository;
import ru.otus.ageev.hw06jpa.service.CommentService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<Comment> getAllByBook(long bookId) {
        return commentRepository.getAllByBook(bookId);
    }
}
