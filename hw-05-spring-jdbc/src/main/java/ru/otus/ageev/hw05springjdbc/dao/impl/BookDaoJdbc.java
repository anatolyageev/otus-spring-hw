package ru.otus.ageev.hw05springjdbc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.ageev.hw05springjdbc.dao.AuthorBookDao;
import ru.otus.ageev.hw05springjdbc.dao.AuthorDao;
import ru.otus.ageev.hw05springjdbc.dao.BookDao;
import ru.otus.ageev.hw05springjdbc.dao.GenreDao;
import ru.otus.ageev.hw05springjdbc.domain.Author;
import ru.otus.ageev.hw05springjdbc.domain.AuthorBook;
import ru.otus.ageev.hw05springjdbc.domain.Book;
import ru.otus.ageev.hw05springjdbc.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoJdbc implements BookDao {
    private final NamedParameterJdbcOperations jdbcOperations;
    private final AuthorBookDao authorBookDao;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;

    @Autowired
    public BookDaoJdbc(NamedParameterJdbcOperations jdbcOperations, AuthorBookDao authorBookDao, AuthorDao authorDao, GenreDao genreDao) {
        this.jdbcOperations = jdbcOperations;
        this.authorBookDao = authorBookDao;
        this.authorDao = authorDao;
        this.genreDao = genreDao;
    }

    @Override
    public List<Book> getAll() {
        return jdbcOperations.query("select * from books", new BookMapper());
    }

    @Override
    public Book getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return jdbcOperations.queryForObject(
                "select * from books where id = :id", params, new BookMapper());
    }

    @Override
    public long insert(Book book) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("title", book.getTitle());
        sqlParameterSource.addValue("page_count", book.getPageCount());
        sqlParameterSource.addValue("genre_id", book.getGenre().getId());
        jdbcOperations.update(
                "insert into books (title, page_count,genre_id) values (:title, :page_count, :genre_id)",
                sqlParameterSource, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public void update(Book book) {
        jdbcOperations.update(
                "update books set title = :title, page_count = :page_count,genre_id = :genre_id where id = :id",
                Map.of("id", book.getId(),
                        "title", book.getTitle(),
                        "page_count", book.getPageCount(),
                        "genre_id", book.getGenre().getId())
        );
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        jdbcOperations.update(
                "delete from books where id = :id", params);
    }

    private class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String title = resultSet.getString("title");
            Integer pageCount = resultSet.getInt("page_count");
            List<AuthorBook> authorBooks = authorBookDao.getByBookId(id);
            List<Author> authorList = new ArrayList<>();
            for (AuthorBook authorBook : authorBooks) {
                authorList.add(authorDao.getById(authorBook.getAuthorId()));
            }
            Genre genre = genreDao.getById(resultSet.getInt("genre_id"));
            return new Book(id, title, pageCount, authorList, genre);
        }
    }
}
