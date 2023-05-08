package com.project.books.controllers;

import com.project.books.entity.User;
import com.project.books.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/registration")
    public String registrationPost(@RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String email) {
        final User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        user.setEmail(email);
        userService.addUser(user);
        return "redirect:/registration";
    }

}
