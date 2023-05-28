package pl.coderslab.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.beans.BookService;
import pl.coderslab.entity.Book;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/books")
public class ManageBookController {

    final BookService bookService;

    @GetMapping("/show-list")
    public String showBooks(Model model){
        model.addAttribute("books", bookService.getBooks());
        return "book/list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable long id, Model model){
        Book book = bookService.getBook(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Nie udało się pobrać książki"));
        model.addAttribute("book", book);
        return "book/edit";
    }
    @PostMapping("/add")
    public String addBook(@Valid Book book, BindingResult result){
        if(result.hasErrors()){
            return "book/add";
        }
        bookService.addBook(book);
        return "redirect:/admin/books/show-list";
    }
    @PostMapping("/edit")
    public String editBook(@Valid Book book, BindingResult result){
        if(result.hasErrors()){
            return "book/edit";
        }
        bookService.updateBook(book);
        return "redirect:/admin/books/show-list";
    }
    @GetMapping("/confirm-cancel/{id}/{title}")
    public String confirmOrCancel(@PathVariable long id, Model model, @PathVariable String title){
        model.addAttribute("id", id);
        model.addAttribute("title", title);
        return "book/delete";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
        return "redirect:/admin/books/show-list";
    }
    @GetMapping("/book-details")
    public String showBookDetails(@RequestParam("search") String search, Model model){
        List<Book> books = Optional.ofNullable(bookService.findBooksBySearchValue(search))
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nie odnaleziono żadnych wyników wyszukiwania"));
        if(books.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nie odnaleziono żadnych wyników wyszukiwania");
        }
        model.addAttribute("books", books);
        return "book/list";
    }
    @GetMapping("/details/{id}")
    public String showSingleBookDetails(@PathVariable long id, Model model){
        Book book = (bookService.getBook(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "book not found")));
        model.addAttribute("book", book);
        return "book/details";
    }

}
