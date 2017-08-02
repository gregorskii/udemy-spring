package com.example.spring5demo.controllers;

import com.example.spring5demo.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(
        AuthorRepository authorRepository
    ) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("")
    public String index(
        Model model
    ) {
        model.addAttribute("authors", authorRepository.findAll());
        return "authors/index";
    }
}
