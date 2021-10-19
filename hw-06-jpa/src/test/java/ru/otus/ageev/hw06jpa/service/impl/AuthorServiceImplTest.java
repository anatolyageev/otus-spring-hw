package ru.otus.ageev.hw06jpa.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.otus.ageev.hw06jpa.domain.Author;
import ru.otus.ageev.hw06jpa.repositories.impl.AuthorRepositoryJpa;

@DisplayName("Jpa repo for Author ")
@DataJpaTest
@Import({AuthorServiceImpl.class, AuthorRepositoryJpa.class})
class AuthorServiceImplTest {
    @Autowired
    private AuthorServiceImpl authorService;
    @Autowired
    private AuthorRepositoryJpa authorRepository;


    private final Author newAuthor = new Author(null, "АлександрNew", "ПушкинNew");

    @Test
    void shouldSaveAuthor() {
        authorService.save(newAuthor);

        System.out.println(authorService.getById(6));
    }
}