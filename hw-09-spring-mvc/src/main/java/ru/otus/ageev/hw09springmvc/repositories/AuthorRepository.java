package ru.otus.ageev.hw09springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.otus.ageev.hw09springmvc.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    public Author  getAuthorIdAndName();
}
