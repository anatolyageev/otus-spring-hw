package ru.otus.ageev.hw06jpa.repositories.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.otus.ageev.hw06jpa.domain.Book;
import ru.otus.ageev.hw06jpa.repositories.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryJpa implements BookRepository {
    @PersistenceContext
    private final EntityManager em;

    public BookRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = em.createQuery("select b from Book b join fetch b.genre" , Book.class);
        return query.getResultList();
    }

    @Override
    public Optional<Book> getById(long id) {
        TypedQuery<Book> query = em.createQuery(
                "select b from Book b join fetch b.genre where b.id = :id"
                , Book.class);
        query.setParameter("id", id);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public long insert(Book book) {

        return 0;
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void deleteById(long id) {

    }
}
