package ru.otus.ageev.hw05springjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.h2.tools.Console;
import org.springframework.context.ApplicationContext;
import ru.otus.ageev.hw05springjdbc.dao.AuthorBookDao;
import ru.otus.ageev.hw05springjdbc.dao.AuthorDao;
import ru.otus.ageev.hw05springjdbc.dao.BookDao;
import ru.otus.ageev.hw05springjdbc.domain.Author;
import ru.otus.ageev.hw05springjdbc.domain.Book;
import ru.otus.ageev.hw05springjdbc.domain.Genre;
import ru.otus.ageev.hw05springjdbc.service.BookService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Hw05SpringJdbcApplication {

    public static void main(String[] args) throws SQLException {
//        SpringApplication.run(Hw05SpringJdbcApplication.class, args);
        ApplicationContext context = SpringApplication.run(Hw05SpringJdbcApplication.class, args);
        BookDao dao =  context.getBean(BookDao.class);
        AuthorBookDao authorBookDao = context.getBean(AuthorBookDao.class);
        AuthorDao authorDao = context.getBean(AuthorDao.class);
        BookService bookService = context.getBean(BookService.class);
        Console.main(args);
        Genre genre = new Genre(1L,"Сатира");
        List<Author> authorList = new ArrayList<>();
        Author author1 = new Author (null,"Николай","Гоголь" );
        Author author2 = new Author (null,"Гоголь","Николай" );
        authorList.add(author1);
        authorList.add(author2);

        Book book = new Book(null,"Мертвые души",689,authorList,genre);
//        System.out.println(dao.getAll());
//        System.out.println(authorBookDao.getByBookId(1));
//        System.out.println(authorDao.getById(4));


        bookService.save(book);

        System.out.println(dao.getAll());


    }

}
