package ru.otus.ageev.hw05springjdbc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ageev.hw05springjdbc.dao.GenreDao;
import ru.otus.ageev.hw05springjdbc.domain.Genre;
import ru.otus.ageev.hw05springjdbc.service.GenreService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreDao genreDao;

    @Override
    public Genre getById(long id) {
        return genreDao.getById(id);
    }

    @Override
    public Genre getByName(String genreName) {
        return genreDao.getByName(genreName);
    }

    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }
}
