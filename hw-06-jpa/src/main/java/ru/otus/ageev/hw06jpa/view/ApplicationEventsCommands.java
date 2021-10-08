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
import ru.otus.ageev.hw06jpa.service.BookService;
import ru.otus.ageev.hw06jpa.service.CommentService;
import ru.otus.ageev.hw06jpa.service.GenreService;
import ru.otus.ageev.hw06jpa.service.InterfaceHelperService;

import java.sql.SQLException;
import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventsCommands {

    private final BookService bookService;
    private final GenreService genreService;
    private final CommentService commentService;
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

    @ShellMethod(value = "get book", key = {"gb", "getBook"})
    public String getBook(@ShellOption Long id) {
        Book book = bookService.getById(id).get();
        return book.toString();
    }

    @ShellMethod(value = "Insert book", key = {"ib", "insertBook"})
    public String insertBook(@ShellOption String title,
                             @ShellOption Integer pageCount,
                             @ShellOption String genreName) {

        BookDto bookDto = new BookDto();
        List<Author> authorList = interfaceHelperService.addAuthors();
        Genre genre = genreService.getByName(genreName);
        bookDto.setGenre(genre);
        bookDto.setTitle(title);
        bookDto.setPageCount(pageCount);
        bookDto.setAuthorList(authorList);
        Book book = bookDto.getItem();
        bookService.save(book);
        return "Book saved";
    }

    @ShellMethod(value = "Update book", key = {"ub", "updateBook"})
    public String updateBook(@ShellOption Long id,
                             @ShellOption String title,
                             @ShellOption Integer pageCount,
                             @ShellOption String genreName) {

        BookDto bookDto = new BookDto(bookService.getById(id).get());
        Genre genre = genreService.getByName(genreName);
        bookDto.setGenre(genre);
        bookDto.setTitle(title);
        bookDto.setPageCount(pageCount);
        Book book = bookDto.getItem();
        bookService.update(book);
        return "Book saved";
    }

    @ShellMethod(value = "Delete book", key = {"db", "deleteBook"})
    public String deleteBook(@ShellOption Long id) {
        bookService.deleteById(id);
        return "Book successfully deleted";
    }

    @ShellMethod(value = "All comments for book", key = {"gcb", "getCommetsBook"})
    public void getAllCommentsForBook(@ShellOption Long id) {
        bookService.getById(id).get().getComments().forEach(System.out::println);
    }
}
