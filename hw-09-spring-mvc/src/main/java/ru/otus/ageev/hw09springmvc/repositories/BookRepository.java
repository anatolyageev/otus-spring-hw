package ru.otus.ageev.hw09springmvc.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ageev.hw09springmvc.domain.Book;

import java.util.List;

public interface BookRepository extends JpaRepository <Book, Long> {
    @EntityGraph(attributePaths = {"genre","authors"})
    @Override
    List<Book> findAll();
}
