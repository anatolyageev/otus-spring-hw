package ru.otus.ageev.hw05springjdbc.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.otus.ageev.hw05springjdbc.domain.Author;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AuthorDto {
    private Long id;
    private String name;
    private String surname;

    public AuthorDto(Author author) {
        id = author.getId();
        name = author.getName();
        surname = author.getSurname();
    }

    public Author getItem(){
        return new Author(id, name, surname);
    }
}
