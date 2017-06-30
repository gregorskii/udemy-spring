package com.luv2code.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ShoutController {

    @RequestMapping("/shout")
    public String letsShout() {
        return "shout-form/form";
    }

    @RequestMapping("/processShout")
    public String processShout(
        // More traditional way to get params
        HttpServletRequest request,
        Model model
    ) {
        model.addAttribute("message", "YO");
        model.addAttribute("name", request.getParameter("name").toUpperCase());

        return "shout-form/form-complete";
    }
}
