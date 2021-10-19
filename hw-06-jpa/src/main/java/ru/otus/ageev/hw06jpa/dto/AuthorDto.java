package ru.otus.ageev.hw06jpa.dto;

import lombok.*;
import ru.otus.ageev.hw06jpa.domain.Author;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDto {
    private Long id;
    private String name;
    private String surname;

    public Author getItem(){
        return new Author(id, name, surname);
    }
}
