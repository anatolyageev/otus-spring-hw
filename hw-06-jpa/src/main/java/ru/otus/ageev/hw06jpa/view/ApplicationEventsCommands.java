package ru.otus.ageev.hw06jpa.view;

import lombok.RequiredArgsConstructor;
import org.h2.tools.Console;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.ageev.hw06jpa.domain.Author;
import ru.otus.ageev.hw06jpa.domain.Book;
import ru.otus.ageev.hw06jpa.domain.Genre;
import ru.otus.ageev.hw06jpa.dto.BookDto;
import ru.otus.ageev.hw06jpa.service.*;

import java.sql.SQLException;
import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventsCommands {

    private final BookService bookService;
    private final GenreService genreService;
    private final CommentService commentService;
    private final AuthorService authorService;
    private final InterfaceHelperService interfaceHelperService;

    @ShellMethod(value = "Run H2 Console", key = {"h2", "runH2Console"})
    public void runH2Console() throws SQLException {
        String[] EMPTY_ARRAY = new String[0];
        Console.main(EMPTY_ARRAY);
    }

    @ShellMethod(value = "All books", key = {"ga", "getAll"})
    public void getAll() {
        List<Book> books = bookService.getAll();
        books.forEach(System.out::println);
    }

    @ShellMethod(value = "All Authors", key = {"gaa", "getAll Authors"})
    public void getAllAuthors() {
        List<Author> authorList = authorService.getAll();
        authorList.forEach(System.out::println);
    }

    @ShellMethod(value = "get book", key = {"gb", "getBook"})
    public String getBook(@ShellOption Long id) {
        Book book = bookService.getById(id).get();
        return book.toString();
    }

    @ShellMethod(value = "Insert book", key = {"ib", "insertBook"})
    public String insertBook(@ShellOption String title,
                             @ShellOption Integer pageCount,
                             @ShellOption String genreName) {
        List<Author> authorList = interfaceHelperService.addAuthors();
        Genre genre = genreService.getByName(genreName);
        BookDto bookDto = BookDto.builder()
                .genre(genre)
                .title(title)
                .pageCount(pageCount)
                .authorList(authorList)
                .build();
        bookService.save(bookDto.getItem());
        return "Book saved";
    }

    @ShellMethod(value = "Insert author", key = {"ia", "insertAuthor"})
    public String insertAuthor(@ShellOption String name,
                               @ShellOption String surname) {
        authorService.save(new Author(null, name, surname));

        return "Author saved";
    }

    @ShellMethod(value = "Update author", key = {"ua", "updateAuthor"})
    public String updateAuthor(@ShellOption Long id,
                               @ShellOption String name,
                               @ShellOption String surname) {
        authorService.save(new Author(id, name, surname));

        return "Author saved";
    }

    @ShellMethod(value = "Update book", key = {"ub", "updateBook"})
    public String updateBook(@ShellOption Long id,
                             @ShellOption String title,
                             @ShellOption Integer pageCount,
                             @ShellOption String genreName) {

        Book book = bookService.getById(id).get();
        BookDto bookDto = BookDto.builder().
                id(book.getId())
                .genre(genreService.getByName(genreName))
                .title(title)
                .pageCount(pageCount)
                .comments(book.getComments())
                .build();
        bookService.update(bookDto.getItem());
        return "Book saved";
    }

    @ShellMethod(value = "Delete book", key = {"db", "deleteBook"})
    public String deleteBook(@ShellOption Long id) {
        bookService.deleteById(id);
        return "Book successfully deleted";
    }

    @ShellMethod(value = "All comments for book", key = {"gcb", "getCommetsBook"})
    public void getAllCommentsForBook(@ShellOption Long id) {
       var comments = bookService.getById(id).get().getComments();
       if (comments.size() != 0){
           comments.forEach(System.out::println);
       }
        System.out.println("There are no comments for this book. You will be first one");
    }
}
