package ru.otus.ageev.hw07springdatajpa.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.ageev.hw07springdatajpa.domain.Author;
import ru.otus.ageev.hw07springdatajpa.domain.Book;
import ru.otus.ageev.hw07springdatajpa.domain.Genre;
import ru.otus.ageev.hw07springdatajpa.repositories.BookRepository;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Jpa repo for Book ")
@DataJpaTest
@Import({BookServiceImpl.class, AuthorServiceImpl.class})
class BookServiceImplTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    AuthorServiceImpl authorService;

    @Autowired
    private TestEntityManager em;

    private final long EXPECTED_BOOK_ID = 6;
    private final long EXPECTED_UPDATED_BOOK_ID = 1;
    private final int EXPECTED_NUMBER_OF_BOOKS = 5;
    private final Book INSERT_BOOK = new Book(null, "Дубровский", 351, Arrays.asList(new Author(1L, "Александр", "Пушкин")),
            new Genre(1L, "Роман"));
    private final Book UPDATE_BOOK = new Book(1L, "Евгений Онегин Updated", 251,
            Arrays.asList(new Author(1L, "Александр", "Пушкин")),
            new Genre(1L, "Роман в стихах"));

    @DisplayName("should return all books")
    @Test
    void getAllShouldReturnExpectedNumberOfBooks() {
        var books = bookService.getAll();

        assertThat(books).isNotNull().hasSize(EXPECTED_NUMBER_OF_BOOKS);
    }


    @DisplayName("should save book with expected id")
    @Test
    void insertBook_ShouldReturnExpectedBookId() {
        long insert = bookService.save(INSERT_BOOK).getId();
        System.out.println("Incerted -----> " + bookRepository.getById(insert));
        assertEquals(EXPECTED_BOOK_ID, insert);
    }

    @DisplayName("should update book with expected id")
    @Test
    void updateBook_ShouldBeEqualToExpected() {
        long update = bookRepository.save(UPDATE_BOOK).getId();
        System.out.println("Update -----> " + bookRepository.getById(update));
        assertEquals(EXPECTED_UPDATED_BOOK_ID, update);
    }
}