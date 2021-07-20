package ru.otus.ageev.hw05springjdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.ageev.hw05springjdbc.dao.AuthorBookDao;
import ru.otus.ageev.hw05springjdbc.domain.AuthorBook;
import ru.otus.ageev.hw05springjdbc.service.AuthorBookService;

import java.util.List;
import java.util.Objects;

@Service
public class AuthorBookServiceImpl implements AuthorBookService {
    private final AuthorBookDao authorBookDao;

    @Autowired
    public AuthorBookServiceImpl(AuthorBookDao authorBookDao) {
        this.authorBookDao = authorBookDao;
    }

    @Override
    public void save(AuthorBook authorBook) {
        if(authorBookDao.isExist(authorBook)){
            authorBookDao.insert(authorBook);
        }
    }

    @Override
    public void saveAll(List<AuthorBook> authorBooks) {
        authorBooks.forEach(this::save);
    }
}
