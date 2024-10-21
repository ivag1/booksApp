package mk.ukim.finki.booksapp.repository;

import mk.ukim.finki.booksapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
