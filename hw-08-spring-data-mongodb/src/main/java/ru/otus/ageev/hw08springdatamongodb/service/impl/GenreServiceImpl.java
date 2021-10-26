package ru.otus.ageev.hw08springdatamongodb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ageev.hw08springdatamongodb.domain.Genre;
import ru.otus.ageev.hw08springdatamongodb.exeptions.ResourceNotFoundException;
import ru.otus.ageev.hw08springdatamongodb.repositories.GenreRepository;
import ru.otus.ageev.hw08springdatamongodb.service.GenreService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    @Override
    public Genre getById(String id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre with such id doesn't exist"));
    }

    @Override
    public Genre getByName(String genreName) {
        return genreRepository.getByGenreName(genreName)
                .orElseThrow(() -> new ResourceNotFoundException("Genre with such name doesn't exist"));
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }
}
