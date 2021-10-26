package ru.otus.ageev.hw08springdatamongodb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.otus.ageev.hw08springdatamongodb.domain.Author;
import ru.otus.ageev.hw08springdatamongodb.domain.Book;
import ru.otus.ageev.hw08springdatamongodb.domain.Comment;
import ru.otus.ageev.hw08springdatamongodb.domain.Genre;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookDto {
    private String id;
    private String title;
    private Integer pageCount;
    private List<Author> authorList;
    private Genre genre;
    private List<Comment> comments;

    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.pageCount = book.getPageCount();
        this.genre = book.getGenre();
        this.comments = book.getComments();
    }

    public Book getItem() {
        return new Book(id, title, pageCount, authorList, genre, comments);
    }
}
