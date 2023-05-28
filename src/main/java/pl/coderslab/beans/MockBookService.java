package pl.coderslab.beans;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MockBookService implements BookService {
    private List<Book> books;
    long id = 4L;


    public MockBookService(){
        books = new ArrayList<>();

        books.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));

        books.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy, Bates Bert", "Helion",

                "programming"));

        books.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion",

                "programming"));
    }
    public List<Book> getBooks(){
        return books;
    }
    public Optional<Book> getBook(long id){
        return Optional.ofNullable(books.stream()
                .filter(n->n.getId()==id)
                .collect(Collectors.toList()).get(0));
    }
    public void addBook(Book book){
        book.setId(getId());
        books.add(book);
        setId(id++);
    }

    public void deleteBook(long id){
        books = books.stream()
                .filter(n->n.getId()!=id)
                .collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void updateBook(Book book){
        books.set(books.indexOf(book), book);

    }

    @Override
    public List<Book> findBooksBySearchValue(String search) {
        return null;
    }


}
