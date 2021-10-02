package ru.otus.ageev.hw06jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.ageev.hw06jpa.repositories.AuthorRepository;
import ru.otus.ageev.hw06jpa.domain.Author;
import ru.otus.ageev.hw06jpa.dto.AuthorDto;
import ru.otus.ageev.hw06jpa.service.AuthorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getById(long id) {
        return authorRepository.getById(id);
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE, propagation = Propagation.NESTED)
    public Author save(Author author) {
        AuthorDto authorDto = new AuthorDto(author);
        if (Objects.isNull(authorDto.getId())) {
            authorDto.setId(authorRepository.insert(author));
        } else {
            authorRepository.update(authorDto.getItem());
        }
        return authorDto.getItem();
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE, propagation = Propagation.NESTED)
    public List<Author> saveAll(List<Author> authorList) {
        List<Author> authors = new ArrayList();
        for (Author author : authorList) {
            authors.add(save(author));
        }
        return authors;
    }


}
