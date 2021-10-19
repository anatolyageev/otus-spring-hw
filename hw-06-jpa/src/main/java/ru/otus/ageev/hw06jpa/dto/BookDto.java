package ru.otus.ageev.hw06jpa.dto;

import lombok.*;
import ru.otus.ageev.hw06jpa.domain.Author;
import ru.otus.ageev.hw06jpa.domain.Book;
import ru.otus.ageev.hw06jpa.domain.Comment;
import ru.otus.ageev.hw06jpa.domain.Genre;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private Long id;
    private String title;
    private Integer pageCount;
    private List<Author> authorList;
    private Genre genre;
    private List<Comment> comments;

    public Book getItem() {
        return new Book(id, title, pageCount, authorList, genre,comments);
    }
}
