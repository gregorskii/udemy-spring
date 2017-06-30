package com.luv2code.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @RequestMapping("/")
    public String index(
        @RequestParam(
            value="name",
            required=false,
            defaultValue="Cats"
        ) String name,
        Model model
    ) {
        model.addAttribute("name", name);
        return "index/index";
    }
}
