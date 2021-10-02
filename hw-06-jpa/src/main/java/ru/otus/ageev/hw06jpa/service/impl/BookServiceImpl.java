package ru.otus.ageev.hw06jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.ageev.hw06jpa.domain.Book;
import ru.otus.ageev.hw06jpa.exeptions.ResourceNotFoundException;
import ru.otus.ageev.hw06jpa.repositories.BookRepository;
import ru.otus.ageev.hw06jpa.service.BookService;

import java.util.List;
import java.util.Optional;

@Service

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public Optional<Book> getById(long id) {
        return bookRepository.getById(id);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void update(Book book) {
        bookRepository.getById(book.getId()).ifPresentOrElse((b) -> bookRepository.save(book), () -> {
            throw new ResourceNotFoundException("Book with id " + book.getId() + " is not found!");
        });
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void deleteById(long id) {
        bookRepository.getById(id).ifPresentOrElse(book -> bookRepository.delete(book), () -> {
            throw new ResourceNotFoundException("Book with id " + id + " is not found!");
        });
    }
}
