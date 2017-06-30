package com.luv2code.springdemo;

import com.luv2code.springdemo.config.ApplicationConfig;
import com.luv2code.springdemo.config.CountriesConfig;
import com.luv2code.springdemo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tag-form")
public class TagFormController {

    @Autowired
    private Student student;

    @Autowired
    private CountriesConfig countriesConfig;

    @RequestMapping("/")
    public String showFormTags(
        Model model
    ) {
        student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("countries", countriesConfig);
        return "test-form-tags/form";
    }

    @RequestMapping("/processForm")
    public String handleFormTags(
        @ModelAttribute(value="student") Student student,
        Model model
    ) {
        model.addAttribute("student", student);
        return "test-form-tags/form-complete";
    }
}
