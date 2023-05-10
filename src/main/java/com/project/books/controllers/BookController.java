package com.project.books.controllers;

import com.project.books.entity.Book;
import com.project.books.entity.User;
import com.project.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Controller
public class BookController {
    private final BookService bookService;

    @ModelAttribute
    public void addGlobalAttributes(Model model) {
        final Set<Book> allBooks = bookService.getAllBooks();

        model.addAttribute("entities", allBooks);
    }

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String hello(Model model,
                        @AuthenticationPrincipal User user) {
        final Set<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("books", allBooks);
        return "index";
    }

    @GetMapping("/form")
    public String formForUser(Model model) {
        final Set<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("books", allBooks);
        return "addBook";
    }

    @PostMapping("/add")
    public String addBook(Book book,
                          @AuthenticationPrincipal User user) {
        book.setAvailable(true);
        book.setUserId(user.getId());
        bookService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String getBook(Model model,
                          @PathVariable Long id,
                          @AuthenticationPrincipal User user) {
        final Book bookById = bookService.getBookById(id);
        if (Objects.equals(user.getId(), bookById.getUserId())) {
            model.addAttribute("id", id);
            return "editBook";
        }

        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id,
                           Model model,
                           Book book,
                           @AuthenticationPrincipal User user) {
        final Book bookById = bookService.getBookById(id);
        if (Objects.nonNull(bookById) && Objects.equals(user.getId(), bookById.getUserId())) {
            model.addAttribute("id", id);
            bookById.setCount(book.getCount());
            bookService.saveBook(bookById);
        }
        return "redirect:/";
    }

    @PostMapping("/payFor/{id}")
    public String payForBook(@PathVariable Long id,
                             Model model) {
        final Book bookById = bookService.getBookById(id);

        model.addAttribute("id", id);

        if (bookById.getCount() != 0) {
            bookService.payThisBook(bookById);
        }

        if (bookById.getCount() == 0) {
            bookById.setAvailable(false);
        }

        bookService.saveBook(bookById);
        return "redirect:/pay/{id}";
    }

    @GetMapping("/pay/{id}")
    public String pay(Model model,
                      @PathVariable Long id) {
        final Book bookById = bookService.getBookById(id);

        Optional.ofNullable(bookById).ifPresentOrElse(book -> {
                },
                () -> model.addAttribute("error", "this book don`t exist"));

        if (Boolean.FALSE.equals(Objects.requireNonNull(bookById).getAvailable())) {
            model.addAttribute("notExist", "This book is not available");
        }

        model.addAttribute("book", bookById);
        return "myBook";
    }

}
