package ru.otus.ageev.hw06jpa.service.impl;

import lombok.val;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.ageev.hw06jpa.repositories.BookRepository;
import ru.otus.ageev.hw06jpa.repositories.impl.BookRepositoryJpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Jpa repo for Book ")
@DataJpaTest
@Import(BookRepositoryJpa.class)
class BookServiceImplTest {
    @Autowired
    private BookRepositoryJpa bookRepository;

    @Autowired
    private TestEntityManager em;

    @DisplayName("should return all books")
    @Test
    void getAll() {
        SessionFactory sessionFactory = em.getEntityManager().getEntityManagerFactory()
                .unwrap(SessionFactory.class);
        sessionFactory.getStatistics().setStatisticsEnabled(true);

        System.out.println("\n\n\n\n----------------------------------------------------------------------------------------------------------");
        val books = bookRepository.getAll();

        books.forEach(System.out::println);

//        assertThat(students).isNotNull().hasSize(EXPECTED_NUMBER_OF_STUDENTS)
//                .allMatch(s -> !s.getName().equals(""))
//                .allMatch(s -> s.getCourses() != null && s.getCourses().size() > 0)
//                .allMatch(s -> s.getAvatar() != null)
//                .allMatch(s -> s.getEmails() != null && s.getEmails().size() > 0);
        System.out.println("----------------------------------------------------------------------------------------------------------\n\n\n\n");

    }
}