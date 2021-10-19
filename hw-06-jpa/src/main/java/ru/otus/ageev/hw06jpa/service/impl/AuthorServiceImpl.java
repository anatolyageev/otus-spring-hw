package ru.otus.ageev.hw06jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.ageev.hw06jpa.domain.Author;
import ru.otus.ageev.hw06jpa.exeptions.ResourceNotFoundException;
import ru.otus.ageev.hw06jpa.repositories.AuthorRepository;
import ru.otus.ageev.hw06jpa.service.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> getAll() {
        return authorRepository.getAll();
    }

    @Override
    public Author getById(long id) {
        return authorRepository.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with such id doesn't exist"));
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void saveAll(List<Author> authorList) {
        authorList.forEach(this::save);
    }
}
