package ru.otus.ageev.hw08springdatamongodb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.otus.ageev.hw08springdatamongodb.domain.Author;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AuthorDto {
    private String id;
    private String name;
    private String surname;

    public AuthorDto(Author author) {

    }

    public Author getItem() {
        return new Author(id, name, surname);
    }
}
