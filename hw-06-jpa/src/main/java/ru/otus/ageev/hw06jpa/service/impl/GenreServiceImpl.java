package ru.otus.ageev.hw06jpa.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ageev.hw06jpa.exeptions.ResourceNotFoundException;
import ru.otus.ageev.hw06jpa.repositories.GenreRepository;
import ru.otus.ageev.hw06jpa.domain.Genre;
import ru.otus.ageev.hw06jpa.service.GenreService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    @Override
    public Genre getById(long id) {
        return genreRepository.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre with such id doesn't exist"));
    }

    @Override
    public Genre getByName(String genreName) {
        return genreRepository.getByName(genreName)
                .orElseThrow(() -> new ResourceNotFoundException("Genre with such name doesn't exist"));
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.getAll();
    }
}
