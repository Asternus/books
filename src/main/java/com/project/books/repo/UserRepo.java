package com.project.books.repo;


import com.project.books.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String nickname);

    User findUsersById(Long id);

    User findUsersByEmail(String email);

    Set<User> findUsersByUsername(String userName);
}
