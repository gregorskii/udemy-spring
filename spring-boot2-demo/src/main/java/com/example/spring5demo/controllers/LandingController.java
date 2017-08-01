package com.example.spring5demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandingController {

    @RequestMapping("/")
    public String index() {
        return "index/index";
    }
}
