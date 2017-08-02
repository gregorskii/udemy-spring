package com.example.spring5demo.controllers;

import com.example.spring5demo.repositories.PublisherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    private PublisherRepository publisherRepository;

    public PublisherController(
        PublisherRepository publisherRepository
    ) {
        this.publisherRepository = publisherRepository;
    }

    @RequestMapping("")
    public String index(
        Model model
    ) {
        model.addAttribute("publishers", publisherRepository.findAll());
        return "publishers/index";
    }
}
