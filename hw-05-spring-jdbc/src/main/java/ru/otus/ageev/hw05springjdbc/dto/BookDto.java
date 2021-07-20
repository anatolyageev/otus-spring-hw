package ru.otus.ageev.hw05springjdbc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.otus.ageev.hw05springjdbc.domain.Author;
import ru.otus.ageev.hw05springjdbc.domain.Book;
import ru.otus.ageev.hw05springjdbc.domain.Genre;

import java.util.List;

@Getter
@Setter
@ToString
public class BookDto {
    private Long id;
    private String title;
    private Integer pageCount;
    private List<Author> authorList;
    private Genre genre;

    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.pageCount= book.getPageCount();
        this.authorList= book.getAuthorList();
        this.genre= book.getGenre();
    }
}
