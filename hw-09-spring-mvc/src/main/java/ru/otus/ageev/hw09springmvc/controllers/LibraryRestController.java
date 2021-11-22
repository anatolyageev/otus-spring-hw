package ru.otus.ageev.hw09springmvc.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.otus.ageev.hw09springmvc.domain.Book;
import ru.otus.ageev.hw09springmvc.dto.BookDto;
import ru.otus.ageev.hw09springmvc.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LibraryRestController {
    private final BookService bookService;

    @GetMapping(value = "/api/library")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooks() {
        return bookService.getAll();
    }

    @DeleteMapping(value = "/api/library/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PostMapping(value = "/api/library/")
    @ResponseStatus(HttpStatus.CREATED)
    public Book post(@RequestBody BookDto book) {
        System.out.println(book);
        return bookService.save(book.getItem());
    }
}
