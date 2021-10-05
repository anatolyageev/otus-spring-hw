package ru.otus.ageev.hw06jpa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.otus.ageev.hw06jpa.domain.Author;
import ru.otus.ageev.hw06jpa.domain.Book;
import ru.otus.ageev.hw06jpa.domain.Genre;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
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
        this.genre= book.getGenre();
    }

    public Book getItem(){
        return new Book(id, title, pageCount, authorList, genre);
    }
}
