package com.luv2code.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @RequestMapping("/form")
    public String showForm() {
        return "test-form/form";
    }

    @RequestMapping("/processForm")
    public String processForm(
        // More Spring like way to get params
        @RequestParam(
            value="name",
            required=false,
            defaultValue="Nameless"
        ) String name,
        Model model) {
        model.addAttribute("message", "Yo");
        model.addAttribute("name", name);
        return "test-form/form-complete";
    }
}
