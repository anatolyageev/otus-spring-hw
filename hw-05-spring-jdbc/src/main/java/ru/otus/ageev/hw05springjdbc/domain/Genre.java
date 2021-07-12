package ru.otus.ageev.hw05springjdbc.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Genre {
    private final Long id;
    private final String genreName;
}
