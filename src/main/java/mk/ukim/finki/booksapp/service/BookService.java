package mk.ukim.finki.booksapp.service;

import mk.ukim.finki.booksapp.model.Book;
import mk.ukim.finki.booksapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
