package ru.otus.ageev.hw09springmvc.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.otus.ageev.hw09springmvc.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
