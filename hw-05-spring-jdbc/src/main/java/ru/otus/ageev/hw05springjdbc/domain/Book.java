package ru.otus.ageev.hw05springjdbc.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Data
@RequiredArgsConstructor
public class Book {
    private final Long id;
    private final String title;
    private final Integer pageCount;
    private final Instant publishedDate;
}
