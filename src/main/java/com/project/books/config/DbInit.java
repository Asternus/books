package com.project.books.config;

import com.project.books.entity.Book;
import com.project.books.entity.Role;
import com.project.books.entity.User;
import com.project.books.repo.BookRepo;
import com.project.books.repo.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
public class DbInit {

    private final UserRepo userRepo;

    private final BookRepo bookRepo;

    public DbInit(UserRepo userRepo, BookRepo bookRepo) {
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
    }

    @PostConstruct
    private void postConstruct() {
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(8);
        final String cat = bCryptPasswordEncoder.encode("cat");

        final User user = new User();
        user.setRoles(Collections.singleton(Role.USER));
        user.setUsername("cat");
        user.setPassword(cat);
        user.setEmail("cat@gmail.com");
        userRepo.save(user);

        for (int i = 0; i < 15; i++) {
            final Book book = new Book();
            book.setCount(Long.valueOf(i));
            book.setAvailable(true);
            book.setName("Book + " + i);
            book.setUserId(user.getId());
            bookRepo.save(book);
        }

        System.out.println("DONE");

    }
}
