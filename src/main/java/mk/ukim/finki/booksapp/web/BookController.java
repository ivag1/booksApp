package mk.ukim.finki.booksapp.web;

import mk.ukim.finki.booksapp.model.Book;
import mk.ukim.finki.booksapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/create")
    public String createBook(Model model) {
        model.addAttribute("book", new Book());
        return "create";
    }

    @PostMapping("/create")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.findById(id).orElse(null));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute("book") Book book) {
        book.setId(id);
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}