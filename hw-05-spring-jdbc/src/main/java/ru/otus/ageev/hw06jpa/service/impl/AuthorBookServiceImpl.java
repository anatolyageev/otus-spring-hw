package ru.otus.ageev.hw06jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.ageev.hw06jpa.repositories.AuthorBookDao;
import ru.otus.ageev.hw06jpa.domain.AuthorBookRelation;
import ru.otus.ageev.hw06jpa.service.AuthorBookService;

import java.util.List;

@Service
public class AuthorBookServiceImpl implements AuthorBookService {
    private final AuthorBookDao authorBookDao;

    @Autowired
    public AuthorBookServiceImpl(AuthorBookDao authorBookDao) {
        this.authorBookDao = authorBookDao;
    }

    @Override
    public void save(AuthorBookRelation authorBook) {
        if(!authorBookDao.isExist(authorBook)){
            authorBookDao.insert(authorBook);
        }
    }

    @Override
    public void saveAll(List<AuthorBookRelation> authorBooks) {
        authorBooks.forEach(this::save);
    }
}
