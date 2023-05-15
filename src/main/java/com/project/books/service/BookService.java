package com.project.books.service;

import com.project.books.entity.Book;
import com.project.books.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookService {
    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Set<Book> getAllBooks() {
        return new HashSet<>(bookRepo.findAll());
    }

    public void saveBook(final Book book) {
        bookRepo.save(book);
    }

    public void payThisBook(final Book book) {
        book.addBook(-1L);
    }

    public Book getBookById(final Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    public Page<Book> getBooks(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return bookRepo.findAll(pageable);
    }

}
