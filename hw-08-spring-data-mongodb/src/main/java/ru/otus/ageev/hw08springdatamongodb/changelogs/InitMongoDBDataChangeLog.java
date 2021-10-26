package ru.otus.ageev.hw08springdatamongodb.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate;
import com.mongodb.client.MongoDatabase;
import ru.otus.ageev.hw08springdatamongodb.domain.Author;
import ru.otus.ageev.hw08springdatamongodb.domain.Book;
import ru.otus.ageev.hw08springdatamongodb.domain.Comment;
import ru.otus.ageev.hw08springdatamongodb.domain.Genre;

@ChangeLog(order = "001")
public class InitMongoDBDataChangeLog {
    private Book book1;
    private Book book2;
    private Book book3;

    @ChangeSet(order = "000", id = "dropDB", author = "aageev", runAlways = true)
    public void dropDB(MongoDatabase database) {
        database.drop();
    }

    @ChangeSet(order = "001", id = "initBooks", author = "aageev", runAlways = true)
    public void initBooks(MongockTemplate repository) {
        book1 = repository.save(new Book("Война и Мир", 1234));
        book2 = repository.save(new Book("Идиот", 234));
        book3 = repository.save(new Book("Евгений Онегин", 443));
    }

    @ChangeSet(order = "002", id = "initAuthors", author = "aageev", runAlways = true)
    public void initAuthors(MongockTemplate repository) {
        Author author1 = repository.save(new Author("Александр", "Пушкин"));
        Author author2 = repository.save(new Author("Лев", "Толстой"));
        Author author3 = repository.save(new Author("Федор", "Достоевский"));
        book1.getAuthors().add(author2);
        book2.getAuthors().add(author3);
        book3.getAuthors().add(author1);
    }

    @ChangeSet(order = "003", id = "initGenres", author = "aageev", runAlways = true)
    public void initGenres(MongockTemplate repository) {
        Genre genre1 = repository.save(new Genre("Сатира"));
        Genre genre2 = repository.save(new Genre("Роман в стихах"));
        Genre genre3 = repository.save(new Genre("Роман"));
        book1.setGenre(genre2);
        book2.setGenre(genre3);
        book3.setGenre(genre3);
    }

    @ChangeSet(order = "004", id = "initComments", author = "aageev", runAlways = true)
    public void initComments(MongockTemplate repository) {
        Comment comment1 = repository.save(new Comment("Comment1"));
        Comment comment2 = repository.save(new Comment("Comment2"));
        Comment comment3 = repository.save(new Comment("Comment3"));
        book1.getComments().add(comment1);
        book2.getComments().add(comment2);
        book3.getComments().add(comment3);
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
    }
}
