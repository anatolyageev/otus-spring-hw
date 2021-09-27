package ru.otus.ageev.hw06jpa.repositories.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.ageev.hw06jpa.repositories.AuthorBookDao;
import ru.otus.ageev.hw06jpa.domain.AuthorBookRelation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorBookDaoJdbc implements AuthorBookDao {
    private final NamedParameterJdbcOperations jdbcOperations;

    public AuthorBookDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<AuthorBookRelation> getByBookId(long id) {
        Map<String, Object> params = Collections.singletonMap("bookId", id);
        return jdbcOperations.query("SELECT AUTHOR_ID, BOOK_ID FROM AUTHORS_BOOKS WHERE BOOK_ID = :bookId", params, new AuthorBookMapper());
    }

    @Override
    public List<AuthorBookRelation> getByAuthorId(long id) {
        Map<String, Object> params = Collections.singletonMap("authorId", id);
        return jdbcOperations.query("SELECT AUTHOR_ID, BOOK_ID FROM AUTHORS_BOOKS WHERE AUTHOR_ID = :authorId", params, new AuthorBookMapper());
    }

    @Override
    public boolean isExist(AuthorBookRelation authorBook) {
        return  jdbcOperations.queryForObject(
                "SELECT count(*) FROM AUTHORS_BOOKS WHERE BOOK_ID = :book_id and author_id =:author_id",
                Map.of("author_id", authorBook.getAuthorId(),
                        "book_id", authorBook.getBookId()), Integer.class) > 0;
    }

    @Override
    public void insert(AuthorBookRelation authorBook) {
        jdbcOperations.update(
                "insert into authors_books (author_id, book_id) values (:author_id, :book_id)",
                Map.of("author_id", authorBook.getAuthorId(),
                        "book_id", authorBook.getBookId())
        );
    }

    @Override
    public void deleteById(AuthorBookRelation authorBook) {

    }

    private static class AuthorBookMapper implements RowMapper<AuthorBookRelation> {

        @Override
        public AuthorBookRelation mapRow(ResultSet resultSet, int i) throws SQLException {
            long authorId = resultSet.getLong("author_id");
            long bookId = resultSet.getLong("book_id");
            return new AuthorBookRelation(authorId, bookId);
        }
    }
}
