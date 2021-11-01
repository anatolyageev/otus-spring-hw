package ru.otus.ageev.hw09springmvc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.otus.ageev.hw09springmvc.domain.Book;
import ru.otus.ageev.hw09springmvc.service.BookService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LibraryController {
    private final BookService bookService;

    @GetMapping("/library")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "library";
    }
}
