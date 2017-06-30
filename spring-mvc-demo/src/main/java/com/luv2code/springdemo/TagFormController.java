package com.luv2code.springdemo;

import com.luv2code.springdemo.config.CountriesConfig;
import com.luv2code.springdemo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

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

        LinkedList<HashMap> personalityTypes = new LinkedList<HashMap>() {{
            add(new HashMap<String, String>() {{
                put("name", "Happy");
                put("text", "Happy");
            }});
            add(new HashMap<String, String>() {{
                put("name", "Sad");
                put("text", "Sad");
            }});
            add(new HashMap<String, String>() {{
                put("name", "Indifferent");
                put("text", "Indifferent");
            }});
            add(new HashMap<String, String>() {{
                put("name", "Angry");
                put("text", "Angry");
            }});
        }};

        ArrayList<String> favoriteSubjectsOptions = new ArrayList<String>() {{
            add("Math");
            add("Science");
            add("Spanish");
            add("Programming");
        }};

        model.addAttribute("personalityTypes", personalityTypes);
        model.addAttribute("favoriteSubjectsOptions", favoriteSubjectsOptions);
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
