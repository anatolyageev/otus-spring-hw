package ru.otus.ageev.hw08springdatamongodb.repositories.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.otus.ageev.hw08springdatamongodb.domain.Author;
import ru.otus.ageev.hw08springdatamongodb.domain.Book;
import ru.otus.ageev.hw08springdatamongodb.domain.Comment;
import ru.otus.ageev.hw08springdatamongodb.repositories.BookRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ComponentScan("ru.otus.ageev.hw08springdatamongodb.events")
class BookCustomRepositoryImplTest {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        mongoTemplate.getDb().drop();
    }

    @DisplayName("should remove author form book")
    @Test
    void removeAuthorElementsById() {
        Author author = mongoTemplate.save(new Author("name", "surname"));
        Book book = mongoTemplate.save(new Book("title", 300));
        book.getAuthors().add(author);
        book = mongoTemplate.save(book);
        assertThat(book.getAuthors()).isNotNull().hasSize(1);
        mongoTemplate.remove(author);
        Optional<Book> book2 = bookRepository.findById(book.getId());
        assertThat(book2.get().getAuthors()).isNotNull().hasSize(0);

    }

    @DisplayName("should remove comment form book")
    @Test
    void removeCommentElementsById() {
        Book book = mongoTemplate.save(new Book("title", 300));
        Comment comment = mongoTemplate.save(new Comment("a1"));
        book.getComments().add(comment);
        book = mongoTemplate.save(book);
        assertThat(book.getComments()).isNotNull().hasSize(1);
        mongoTemplate.remove(comment);
        Optional<Book> book2 = bookRepository.findById(book.getId());
        assertThat(book2.get().getComments()).isNotNull().hasSize(0);
    }

    @DisplayName("should update author for the book")
    @Test
    void setAuthorElementsById() {
        Author author = mongoTemplate.save(new Author("name", "surname"));
        Book book = mongoTemplate.save(new Book("title", 300));
        book.getAuthors().add(author);
        book = mongoTemplate.save(book);
        assertThat(book.getAuthors()).isNotNull().hasSize(1);
        author.setName("123");
        mongoTemplate.save(author);
        Optional<Book> book2 = bookRepository.findById(book.getId());
        assertThat(book2.get().getAuthors()).isNotNull().hasSize(1);
        assertThat(book2.get().getAuthors().iterator().next().getName().equalsIgnoreCase("123"));
    }
}