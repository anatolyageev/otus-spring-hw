package ru.otus.ageev.hw09springmvc.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.otus.ageev.hw09springmvc.domain.Author;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AuthorDto {
    private Long id;
    private String name;
    private String surname;

    public AuthorDto(Author author) {

    }

    public Author getItem(){
        return new Author(id, name, surname);
    }
}
