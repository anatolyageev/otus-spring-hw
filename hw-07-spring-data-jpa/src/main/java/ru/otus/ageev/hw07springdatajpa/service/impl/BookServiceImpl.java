package ru.otus.ageev.hw07springdatajpa.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.ageev.hw07springdatajpa.domain.Book;
import ru.otus.ageev.hw07springdatajpa.exeptions.ResourceNotFoundException;
import ru.otus.ageev.hw07springdatajpa.repositories.BookRepository;
import ru.otus.ageev.hw07springdatajpa.service.AuthorService;
import ru.otus.ageev.hw07springdatajpa.service.BookService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

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
        authorService.saveAll(book.getAuthors());
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
        bookRepository.getById(id).ifPresentOrElse(bookRepository::delete, () -> {
            throw new ResourceNotFoundException("Book with id " + id + " is not found!");
        });
    }
}
