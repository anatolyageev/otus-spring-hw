package ru.otus.ageev.hw06jpa.repositories.impl;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.ageev.hw06jpa.dto.BookDto;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Jpa repo for Comment ")
@DataJpaTest
@Import({CommentRepositoryJpa.class, BookRepositoryJpa.class})
class CommentRepositoryJpaTest {
    @Autowired
    private CommentRepositoryJpa repository;

    @Autowired
    private BookRepositoryJpa bookRepository;

    @Autowired
    private TestEntityManager em;

    @DisplayName("should return all comments")
    @Test
    void getAllShouldReturnExpectedNumberOfComments() {
        var comments = repository.getAll();

        comments.forEach(System.out::println);

        assertThat(comments).isNotNull().hasSize(5);
    }

    @DisplayName("should return all comments for book")
    @Test
    void getAllShouldReturnExpectedNumberOfCommentsForBook() {
        var comments = bookRepository.getById(2L).get().getComments();

        assertThat(comments).isNotNull().hasSize(1);
    }
}