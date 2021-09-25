package ru.otus.ageev.hw05springjdbc.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthorBookRelation {
    private final Long authorId;
    private final Long bookId;
}
