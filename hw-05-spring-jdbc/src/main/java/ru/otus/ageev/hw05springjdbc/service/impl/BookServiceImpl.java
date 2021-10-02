package ru.otus.ageev.hw05springjdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.ageev.hw05springjdbc.dao.BookDao;
import ru.otus.ageev.hw05springjdbc.domain.AuthorBookRelation;
import ru.otus.ageev.hw05springjdbc.domain.Book;
import ru.otus.ageev.hw05springjdbc.dto.BookDto;
import ru.otus.ageev.hw05springjdbc.service.AuthorBookService;
import ru.otus.ageev.hw05springjdbc.service.AuthorService;
import ru.otus.ageev.hw05springjdbc.service.BookService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;
    private final AuthorService authorService;
    private final AuthorBookService authorBookService;

    @Autowired
    public BookServiceImpl(BookDao bookDao, AuthorService authorService, AuthorBookService authorBookService) {
        this.bookDao = bookDao;
        this.authorService = authorService;
        this.authorBookService = authorBookService;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public Book getById(long id) {
        return bookDao.getById(id);
    }

    @Override
    public void save(Book book) {
        BookDto bookDto = new BookDto(book);
        if (Objects.isNull(book.getId())) {
            bookDto.setId(bookDao.insert(book));
        } else {
            bookDao.update(book);
        }
        bookDto.setAuthorList(authorService.saveAll(bookDto.getAuthorList()));

        List<AuthorBookRelation> authorBooks = bookDto.getAuthorList().stream()
                .map(author -> new AuthorBookRelation(author.getId(), bookDto.getId()))
                .collect(Collectors.toList());
        authorBookService.saveAll(authorBooks);
    }

    @Override
    public void deleteById(long id) {
        bookDao.deleteById(id);
    }
}
