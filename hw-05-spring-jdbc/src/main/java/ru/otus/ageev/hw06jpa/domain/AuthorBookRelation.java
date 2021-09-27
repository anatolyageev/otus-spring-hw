package ru.otus.ageev.hw06jpa.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthorBookRelation {
    private final Long authorId;
    private final Long bookId;
}
