package ru.otus.ageev.hw06jpa.domain;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer pageCount;

    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "authors_books",joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;
}
