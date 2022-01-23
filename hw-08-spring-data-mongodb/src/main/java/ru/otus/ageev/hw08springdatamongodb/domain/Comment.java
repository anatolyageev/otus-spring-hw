package ru.otus.ageev.hw08springdatamongodb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "comments")
@ToString
@Getter
public class Comment {
    @Id
    private String id;
    private String comment;
    @DBRef
    private Book book;

    public Comment(String comment) {
        this.comment = comment;
    }
}
