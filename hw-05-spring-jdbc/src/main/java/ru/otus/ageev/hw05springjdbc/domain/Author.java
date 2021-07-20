package ru.otus.ageev.hw05springjdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Author {
    private final Long id;
    private final String name;
    private final String surname;
}
