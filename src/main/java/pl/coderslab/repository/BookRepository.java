package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Book;

import java.util.List;



public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where b.author like :search or b.publisher like :search or b.title like :search or b.isbn like :search or b.id = :search or b.type like :search")
    List<Book> findBooksBySearchValue(@Param("search") String search);

}
