package com.example.medicalhelp.controller;

import com.example.medicalhelp.utils.AuthChecker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    AuthChecker authChecker = new AuthChecker();
    @GetMapping("/")
    public String authCheck(Model model) {
        model.addAttribute("auth", authChecker.getAuth());
        return "index";
    }
}
