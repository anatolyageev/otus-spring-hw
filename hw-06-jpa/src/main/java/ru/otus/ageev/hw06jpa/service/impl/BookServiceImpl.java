package ru.otus.ageev.hw06jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.ageev.hw06jpa.domain.Book;
import ru.otus.ageev.hw06jpa.repositories.BookRepository;
import ru.otus.ageev.hw06jpa.service.AuthorService;
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
    @Transactional
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public Optional<Book> getById(long id) {
        return bookRepository.getById(id);
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }
}
