package com.project.books.service;

import com.project.books.entity.Book;
import com.project.books.repo.BookRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BookServiceTest {

    private BookService target;

    private BookRepo bookRepo;

    @BeforeEach
    void setUp() {
        bookRepo = Mockito.mock(BookRepo.class);
        target = new BookService(bookRepo);
    }

    @Test
    void payThisBook() {
        final List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());
        books.add(new Book());

        Mockito.when(bookRepo.findAll()).thenReturn(books);

        final Set<Book> result = target.getAllBooks();

        assertThat(result)
                .isNotEmpty();

        assertThat(result)
                .hasSize(3);

        assertThat(result)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(books);
    }
}