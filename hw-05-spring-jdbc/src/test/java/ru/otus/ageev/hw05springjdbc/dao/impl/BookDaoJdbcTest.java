package ru.otus.ageev.hw05springjdbc.dao.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.ageev.hw05springjdbc.dao.AuthorBookDao;
import ru.otus.ageev.hw05springjdbc.dao.AuthorDao;
import ru.otus.ageev.hw05springjdbc.dao.BookDao;
import ru.otus.ageev.hw05springjdbc.dao.GenreDao;
import ru.otus.ageev.hw05springjdbc.domain.Author;
import ru.otus.ageev.hw05springjdbc.domain.Book;
import ru.otus.ageev.hw05springjdbc.domain.Genre;
import ru.otus.ageev.hw05springjdbc.dto.BookDto;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Dao for work with books should")
@JdbcTest
@Import({BookDaoJdbc.class, AuthorBookDaoJdbc.class, AuthorDaoJdbc.class, GenreDaoJdbc.class})
class BookDaoJdbcTest {


    @Autowired
    private AuthorBookDao authorBookDao;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private GenreDao genreDao;
    @Autowired
    private BookDao bookDao;

    private final int NUMBER_OF_BOOKS_EXPECTED = 1;
    private final Book EXPECTED_BOOK = new Book(1L, "Евгений Онегин", 251, Arrays.asList(new Author(1L, "Александр", "Пушкин")), new Genre(1L, "Роман в стихах"));
    private final Book INSERT_BOOK = new Book(null, "Дубровский", 351, Arrays.asList(new Author(1L, "Александр", "Пушкин")), new Genre(1L, "Роман"));
    private final long EXPECTED_BOOK_ID = 2;
    private final BookDto UPDATE_BOOK = new BookDto(new Book(EXPECTED_BOOK_ID, "Дубровский Updated", 351, Arrays.asList(new Author(1L, "Александр", "Пушкин")), new Genre(1L, "Роман")));


    @DisplayName("Should return expected number of books")
    @Test
    void shouldReturnExpectedNumberBooks() {
        int actualBookCount = bookDao.getAll().size();

        assertEquals(NUMBER_OF_BOOKS_EXPECTED, actualBookCount);
    }

    @DisplayName("Should return expected book by id")
    @Test
    void shouldReturnExpectedBookById() {
        var actualBook = bookDao.getById(1L);

        assertEquals(EXPECTED_BOOK, actualBook);
    }

    @DisplayName("Should insert book")
    @Test
    void shouldInsertBook() {
        long insert = bookDao.insert(INSERT_BOOK);

        assertEquals(EXPECTED_BOOK_ID, insert);
    }

    @DisplayName("Should update book")
    @Test
    void shouldUpdateBook() {
        long insertId =  bookDao.insert(INSERT_BOOK);
        UPDATE_BOOK.setId(insertId);
        bookDao.update(UPDATE_BOOK.getItem());

        assertEquals(UPDATE_BOOK.getTitle(), bookDao.getById(insertId).getTitle());
    }

    @DisplayName("Should delete book by id")
    @Test
    void shouldDeleteBookById() {
        long insertId = bookDao.insert(INSERT_BOOK);
        bookDao.getAll().forEach(System.out::println);
        bookDao.deleteById(insertId);
        bookDao.getAll().forEach(System.out::println);
        assertEquals(NUMBER_OF_BOOKS_EXPECTED, bookDao.getAll().size());
    }
}