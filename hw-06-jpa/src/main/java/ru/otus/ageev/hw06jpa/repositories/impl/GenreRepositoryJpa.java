package ru.otus.ageev.hw06jpa.repositories.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.ageev.hw06jpa.domain.Genre;
import ru.otus.ageev.hw06jpa.repositories.GenreRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GenreRepositoryJpa implements GenreRepository {
    @PersistenceContext
    private final EntityManager em;

    @Override
    public Optional<Genre> getById(long id) {
        return Optional.ofNullable(em.find(Genre.class, id));
    }

    @Override
    public Genre save(Genre genre) {
        if (genre.getId() == null) {
            em.persist(genre);
        } else {
            return em.merge(genre);
        }
        return genre;
    }

    @Override
    public void delete(Genre genre) {
        em.remove(genre);
    }

    @Override
    public Optional<Genre> getByName(String genreName) {
        TypedQuery<Genre> query = em.createQuery(
                "select g from Genre g where g.genreName = :genreName"
                , Genre.class);
        query.setParameter("genreName", genreName);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Genre> getAll() {
        TypedQuery<Genre> query = em.createQuery("select g from Genre g", Genre.class);
        return query.getResultList();
    }
}
