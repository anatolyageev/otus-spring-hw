package ru.otus.ageev.hw05springjdbc.view;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.ageev.hw05springjdbc.domain.Author;
import ru.otus.ageev.hw05springjdbc.domain.Book;
import ru.otus.ageev.hw05springjdbc.domain.Genre;
import ru.otus.ageev.hw05springjdbc.dto.BookDto;
import ru.otus.ageev.hw05springjdbc.service.AuthorService;
import ru.otus.ageev.hw05springjdbc.service.BookService;
import ru.otus.ageev.hw05springjdbc.service.GenreService;
import ru.otus.ageev.hw05springjdbc.service.InterfaceHelperService;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventsCommands {

    private final BookService bookService;
    private final GenreService genreService;
    private final InterfaceHelperService interfaceHelperService;

    @ShellMethod(value = "All books", key = {"ga", "getAll"})
    public void getAll() {
        List<Book> books = bookService.getAll();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @ShellMethod(value = "get book", key = {"gb", "getBook"})
    public String getBook(@ShellOption Long id) {
        return bookService.getById(id).toString();
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

        BookDto bookDto = new BookDto(bookService.getById(id));
        Genre genre = genreService.getByName(genreName);
        bookDto.setGenre(genre);
        bookDto.setTitle(title);
        bookDto.setPageCount(pageCount);
        Book book = bookDto.getItem();
        bookService.save(book);
        return "Book saved";
    }

    @ShellMethod(value = "Delete book", key = {"db", "deleteBook"})
    public String deleteBook(@ShellOption Long id) {
        bookService.deleteById(id);
        return "Book successfully deleted";
    }

}
