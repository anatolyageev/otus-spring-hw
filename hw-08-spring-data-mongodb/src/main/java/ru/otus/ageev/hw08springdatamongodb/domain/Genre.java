package ru.otus.ageev.hw08springdatamongodb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "genres")
@ToString
@Getter
public class Genre {
    @Id
    private String id;
    private String genreName;

    public Genre(String genreName) {
        this.genreName = genreName;
    }
}
