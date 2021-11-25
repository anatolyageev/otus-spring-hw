package ru.otus.ageev.hw09springmvc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.otus.ageev.hw09springmvc.domain.Genre;
import ru.otus.ageev.hw09springmvc.service.GenreService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @GetMapping(value="/api/genre")
    @ResponseStatus(HttpStatus.OK)
    public List<Genre> getAll(){
        System.out.println(genreService.getAll());
       return genreService.getAll();
    }

    @PostMapping(value = "/api/genre")
    @ResponseStatus(HttpStatus.CREATED)
    public Genre saveGenre(@RequestBody Genre genre) {
        System.out.println(genre);
        return genreService.save(genre);
    }
}
