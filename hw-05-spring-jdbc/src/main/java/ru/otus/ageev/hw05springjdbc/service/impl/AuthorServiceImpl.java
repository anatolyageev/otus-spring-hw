package ru.otus.ageev.hw05springjdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.ageev.hw05springjdbc.dao.AuthorDao;
import ru.otus.ageev.hw05springjdbc.domain.Author;
import ru.otus.ageev.hw05springjdbc.service.AuthorService;

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
    public void save(Author author) {
        if(Objects.isNull( author.getId())){
            authorDao.insert(author);
        }else{
            authorDao.update(author);
        }
    }

    @Override
    public void saveAll(List<Author> authorList) {
        authorList.forEach(this::save);
    }


}
