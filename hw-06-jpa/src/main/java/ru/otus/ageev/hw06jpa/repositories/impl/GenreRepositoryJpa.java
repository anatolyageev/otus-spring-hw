package ru.otus.ageev.hw06jpa.repositories.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.ageev.hw06jpa.repositories.GenreRepository;
import ru.otus.ageev.hw06jpa.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class GenreRepositoryJpa implements GenreRepository {
    private final NamedParameterJdbcOperations jdbcOperations;

    public GenreRepositoryJpa(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Genre getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return jdbcOperations.queryForObject(
                "select id, genre_name from genres where id = :id", params, new GenreMapper());
    }

    @Override
    public Genre getByName(String genreName) {
        Map<String, Object> params = Collections.singletonMap("genre_name", genreName);
        return jdbcOperations.queryForObject(
                "select id, genre_name from genres where genre_name = :genre_name", params, new GenreMapper());
    }

    @Override
    public List<Genre> getAll() {
        return jdbcOperations.query("select id, genre_name from genres", new GenreMapper());
    }

    private static class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String genreName = resultSet.getString("genre_name");
            return new Genre(id, genreName);
        }
    }
}
