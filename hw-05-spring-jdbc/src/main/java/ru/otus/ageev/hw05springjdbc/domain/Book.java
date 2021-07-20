package ru.otus.ageev.hw05springjdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Book {
    private final Long id;
    private final String title;
    private final Integer pageCount;
    private  List<Author> authorList;
    private final Genre genre;
}
