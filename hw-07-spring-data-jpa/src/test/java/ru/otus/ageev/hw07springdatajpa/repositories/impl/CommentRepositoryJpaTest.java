package ru.otus.ageev.hw07springdatajpa.repositories.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Jpa repo for Comment ")
@DataJpaTest
@Import(CommentRepositoryJpa.class)
class CommentRepositoryJpaTest {
    @Autowired
    private CommentRepositoryJpa repository;

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
        var comments = repository.getAllByBook(2L);

        assertThat(comments).isNotNull().hasSize(1);
    }

    @DisplayName("should delete comment")
    @Test
    void deleteCommentShouldRemainEmptyAfterDelete() {
        var comments = repository.getAllByBook(2L);
        repository.delete(comments.get(0));
        comments = repository.getAllByBook(2L);
        assertThat(comments).isNotNull().hasSize(0);
    }
}