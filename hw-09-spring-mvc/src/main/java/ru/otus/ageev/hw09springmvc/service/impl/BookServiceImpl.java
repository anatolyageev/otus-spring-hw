package ru.otus.ageev.hw09springmvc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.ageev.hw09springmvc.domain.Book;
import ru.otus.ageev.hw09springmvc.exeptions.ResourceNotFoundException;
import ru.otus.ageev.hw09springmvc.repositories.BookRepository;
import ru.otus.ageev.hw09springmvc.service.AuthorService;
import ru.otus.ageev.hw09springmvc.service.BookService;

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
        return bookRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public Optional<Book> getById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Book save(Book book) {
        authorService.saveAll(book.getAuthors());
        return bookRepository.save(book);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void update(Book book) {
        bookRepository.findById(book.getId()).ifPresentOrElse((b) -> bookRepository.save(book), () -> {
            throw new ResourceNotFoundException("Book with id " + book.getId() + " is not found!");
        });
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void deleteById(long id) {
        bookRepository.findById(id).ifPresentOrElse(bookRepository::delete, () -> {
            throw new ResourceNotFoundException("Book with id " + id + " is not found!");
        });
    }
}
