package pl.coderslab.beans;


import org.springframework.stereotype.Service;
import pl.coderslab.entity.Book;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    List<Book> getBooks();

    Optional<Book> getBook(long id);

    void addBook(Book book);

    void deleteBook(long id);

    void updateBook(Book book);

    List<Book> findBooksBySearchValue(String search);

}
