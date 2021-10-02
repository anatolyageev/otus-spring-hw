package ru.otus.ageev.hw05springjdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.ageev.hw05springjdbc.dao.AuthorDao;
import ru.otus.ageev.hw05springjdbc.domain.Author;
import ru.otus.ageev.hw05springjdbc.dto.AuthorDto;
import ru.otus.ageev.hw05springjdbc.service.AuthorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;

    @Autowired
    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author getById(long id) {
        return authorDao.getById(id);
    }

    @Override
    public Author save(Author author) {
        AuthorDto authorDto = new AuthorDto(author);
        if (Objects.isNull(authorDto.getId())) {
            authorDto.setId(authorDao.insert(author));
        } else {
            authorDao.update(authorDto.getItem());
        }
        return authorDto.getItem();
    }

    @Override
    public List<Author> saveAll(List<Author> authorList) {
        List<Author> authors = new ArrayList();
        for (Author author : authorList) {
            authors.add(save(author));
        }
        return authors;
    }


}
