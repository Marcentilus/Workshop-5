package pl.coderslab.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.entity.Book;
import pl.coderslab.beans.BookService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class BookController {
   final private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBookList(){
        return bookService.getBooks();
    }


    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable long id){
        if(bookService.getBook(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        return bookService.getBook(id).get();
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book){

        bookService.addBook(book);
    }
    @DeleteMapping("books/{id}")
    public void deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
    }

    @PutMapping("books")
    public void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    }
}
