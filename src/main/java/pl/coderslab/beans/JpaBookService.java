package pl.coderslab.beans;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Book;
import pl.coderslab.repository.BookRepository;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Primary
public class JpaBookService implements BookService{


    final BookRepository bookRepository;



    public List<Book> getBooks(){
       return bookRepository.findAll();
    }
    public Optional<Book> getBook(long id){

         return bookRepository.findById(id);

    }
    public void addBook(Book book){
        bookRepository.save(book);
    }
    public void deleteBook(long id){
        bookRepository.deleteById(id);
    }
    public void updateBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> findBooksBySearchValue(String search){

      return bookRepository.findBooksBySearchValue(search);

    }

}
