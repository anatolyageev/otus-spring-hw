package ru.otus.ageev.hw06jpa.repositories.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.ageev.hw06jpa.domain.Author;
import ru.otus.ageev.hw06jpa.repositories.AuthorRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorRepositoryJpa implements AuthorRepository {
    private final NamedParameterJdbcOperations jdbcOperations;

    public AuthorRepositoryJpa(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Author> getAll() {
        return null;
    }

    @Override
    public Author getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return jdbcOperations.queryForObject(
                "select * from authors where id = :id", params, new AuthorMapper());
    }

    @Override
    public long insert(Author author) {
           return 0L;
    }

    @Override
    public void update(Author author) {

    }

    private class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            return new Author(id, name, surname);
        }
    }
}
