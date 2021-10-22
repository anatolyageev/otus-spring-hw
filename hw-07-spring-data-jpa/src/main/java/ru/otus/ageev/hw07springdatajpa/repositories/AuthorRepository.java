package ru.otus.ageev.hw07springdatajpa.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.otus.ageev.hw07springdatajpa.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
