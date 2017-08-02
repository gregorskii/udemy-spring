package com.example.spring5demo.controllers;

import com.example.spring5demo.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookRepository bookRepository;

    public BookController(
        BookRepository bookRepository
    ) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("")
    public String index(
        Model model
    ) {
        model.addAttribute("books", bookRepository.findAll());
        return "books/index";
    }
}
