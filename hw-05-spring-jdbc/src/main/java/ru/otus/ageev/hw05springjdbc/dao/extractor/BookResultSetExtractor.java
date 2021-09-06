package ru.otus.ageev.hw05springjdbc.dao.extractor;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import ru.otus.ageev.hw05springjdbc.domain.Author;
import ru.otus.ageev.hw05springjdbc.domain.Book;
import ru.otus.ageev.hw05springjdbc.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BookResultSetExtractor implements ResultSetExtractor<Map<Long, Book>> {
    @Override
    public Map<Long, Book> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Long, Book> books = new HashMap<>();
        while (rs.next()) {
            long id = rs.getLong("id");
            Book book = books.get(id);
            if (book == null) {
                book = new Book(id, rs.getString("title"), rs.getInt("page_count"),
                        new ArrayList<>(),
                        new Genre(rs.getLong("genre_id"),rs.getString("genre_name")));
                books.put(id, book);
            }
            book.getAuthorList().add(new Author(
                    rs.getLong("author_id"),
                    rs.getString("name"),
                    rs.getString("surname")));
        }
        return books;
    }
}
