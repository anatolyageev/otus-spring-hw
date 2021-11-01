package ru.otus.ageev.hw08springdatamongodb.repositories.impl;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import ru.otus.ageev.hw08springdatamongodb.domain.Author;
import ru.otus.ageev.hw08springdatamongodb.domain.Book;
import ru.otus.ageev.hw08springdatamongodb.domain.Genre;
import ru.otus.ageev.hw08springdatamongodb.repositories.BookCustomRepository;

@RequiredArgsConstructor
public class BookCustomRepositoryImpl implements BookCustomRepository {
    private final MongoTemplate mongoTemplate;

    @Override
    public void setAuthorElementsById(Author author) {
        var query = Query.query(Criteria.where("authors._id").is(author.getId()));
        var update = new Update().set("authors.$.name", author.getName())
                                          .set("authors.$.surname", author.getSurname());
        mongoTemplate.updateMulti(query, update, Book.class);
    }

    @Override
    public void setGenreElementsById(Genre genre) {
        val query = Query.query(Criteria.where("genres._id").is(genre.getId()));
        val update = new Update().set("genres.$.genreName", genre.getGenreName());
        mongoTemplate.updateMulti(query, update, Book.class);
    }

    @Override
    public void removeAuthorElementsById(String id) {
        var query = Query.query(Criteria.where("_id").is(new ObjectId(id)));
        var update = new Update().pull("authors", query);
        mongoTemplate.updateMulti(new Query(), update, Book.class);
    }

    @Override
    public void removeCommentElementsById(String id) {
        var query = Query.query(Criteria.where("$id").is(new ObjectId(id)));
        var update = new Update().pull("comments", query);
        mongoTemplate.updateMulti(new Query(), update, Book.class);
    }
}
