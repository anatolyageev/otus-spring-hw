package ru.otus.ageev.hw08springdatamongodb.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String title;
    private Integer pageCount;
    private List<Author> authors = new ArrayList<>();
    private Genre genre;
    @DBRef
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();

    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public Book(String title, int pageCount, List<Author> authors, Genre genre, List<Comment> comments) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public Book(String id, String title, int pageCount, List<Author> authors, Genre genre) {
        this.id = id;
        this.title = title;
        this.pageCount = pageCount;
        this.authors = authors;
        this.genre = genre;
    }
}
