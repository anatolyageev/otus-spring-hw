package ru.otus.ageev.hw06jpa.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.ageev.hw06jpa.repositories.AuthorBookDao;
import ru.otus.ageev.hw06jpa.repositories.AuthorDao;
import ru.otus.ageev.hw06jpa.repositories.BookDao;
import ru.otus.ageev.hw06jpa.repositories.GenreDao;
import ru.otus.ageev.hw06jpa.repositories.impl.AuthorBookDaoJdbc;
import ru.otus.ageev.hw06jpa.repositories.impl.AuthorDaoJdbc;
import ru.otus.ageev.hw06jpa.repositories.impl.BookDaoJdbc;
import ru.otus.ageev.hw06jpa.repositories.impl.GenreDaoJdbc;
import ru.otus.ageev.hw06jpa.domain.Author;
import ru.otus.ageev.hw06jpa.domain.Book;
import ru.otus.ageev.hw06jpa.domain.Genre;
import ru.otus.ageev.hw06jpa.service.AuthorBookService;
import ru.otus.ageev.hw06jpa.service.AuthorService;
import ru.otus.ageev.hw06jpa.service.BookService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Dao for work with books should")
@JdbcTest
@Import({BookServiceImpl.class, BookDaoJdbc.class, AuthorServiceImpl.class, AuthorBookServiceImpl.class, AuthorBookDaoJdbc.class, AuthorDaoJdbc.class, GenreDaoJdbc.class})
class BookServiceImplTest {

    @Autowired
    private AuthorBookDao authorBookDao;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private GenreDao genreDao;
    @Autowired
    private BookService bookService;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private AuthorBookService authorBookService;

    private final int NUMBER_OF_BOOKS_EXPECTED = 1;
    private final Book EXPECTED_BOOK = new Book(1L, "Евгений Онегин", 251, Arrays.asList(new Author(1L, "Александр", "Пушкин")), new Genre(1L, "Роман в стихах"));
    private final Book INSERT_BOOK = new Book(null, "Дубровский", 351, Arrays.asList(new Author(1L, "Александр", "Пушкин")), new Genre(1L, "Роман"));
    private final long EXPECTED_BOOK_ID = 2;

    @Test
    void save() {
        long insert = bookDao.insert(INSERT_BOOK);

        assertEquals(EXPECTED_BOOK_ID, insert);
    }

    @Test
    void getAll() {
        int actualBookCount = bookDao.getAll().size();

        assertEquals(NUMBER_OF_BOOKS_EXPECTED, actualBookCount);
    }

    @Test
    void getById() {
        var actualBook = bookDao.getById(1L);

        assertEquals(EXPECTED_BOOK, actualBook);
    }

    @Test
    void deleteById() {
        long insertId = bookDao.insert(INSERT_BOOK);
        bookDao.getAll().forEach(System.out::println);
        bookDao.deleteById(insertId);
        bookDao.getAll().forEach(System.out::println);
        assertEquals(NUMBER_OF_BOOKS_EXPECTED, bookDao.getAll().size());
    }
}