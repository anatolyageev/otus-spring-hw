package ru.otus.ageev.hw06jpa.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository <T>{
    List<T> getAll();

    Optional<T> getById(long id);

    T save(T t);

    void delete(T t);
}
